package net.medcrm.yjb.workflow.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.dateutil.DateHandler;
import net.medcrm.yjb.his.fileutil.Base64Util;
import net.medcrm.yjb.workflow.common.RestServiceController;
import net.medcrm.yjb.workflow.util.BaseResponse;
import net.medcrm.yjb.workflow.util.Status;

/**
 * 模型管理
 */
@RestController
@CrossOrigin
@RequestMapping("models")
public class ModelerController implements RestServiceController<Model, String> {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	RepositoryService repositoryService;
	@Autowired
	ObjectMapper objectMapper;

	/**
	 * 新建一个空模型
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ApiOperation(value = "流程设计器--新建一个空模型", notes = "", httpMethod = "POST")
	@PostMapping("newModel")
	public Object newModel() throws UnsupportedEncodingException {
		// 初始化一个空模型
		Model model = repositoryService.newModel();

		// 设置一些默认信息
		String name = "new-process";
		String description = "";
		int revision = 1;
		String key = "process";

		ObjectNode modelNode = objectMapper.createObjectNode();
		modelNode.put(ModelDataJsonConstants.MODEL_NAME, name);
		modelNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
		modelNode.put(ModelDataJsonConstants.MODEL_REVISION, revision);

		model.setName(name);
		model.setKey(key);
		model.setMetaInfo(modelNode.toString());

		repositoryService.saveModel(model);
		String id = model.getId();

		// 完善ModelEditorSource
		ObjectNode editorNode = objectMapper.createObjectNode();
		editorNode.put("id", "canvas");
		editorNode.put("resourceId", "canvas");
		ObjectNode stencilSetNode = objectMapper.createObjectNode();
		stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
		editorNode.put("stencilset", stencilSetNode);
		repositoryService.addModelEditorSource(id, editorNode.toString().getBytes("utf-8"));
		return new BaseResp<>(ResultStatus.SUCCESS);
	}
	
	 /**
     * 创建模型
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Object create(@RequestParam("name") String name, @RequestParam("key") String key, 
    		@RequestParam("description") String description) {
    	int revision = 1;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode editorNode = objectMapper.createObjectNode();
            editorNode.put("id", "canvas");
            editorNode.put("resourceId", "canvas");
            ObjectNode stencilSetNode = objectMapper.createObjectNode();
            stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
            editorNode.put("stencilset", stencilSetNode);
            Model modelData = repositoryService.newModel();

            ObjectNode modelObjectNode = objectMapper.createObjectNode();
            modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
            modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, revision);
            description = StringUtils.defaultString(description);
            modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
            modelData.setMetaInfo(modelObjectNode.toString());
            modelData.setName(name);
            modelData.setKey(StringUtils.defaultString(key));

            repositoryService.saveModel(modelData);
            repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));

            //response.sendRedirect(request.getContextPath() + "/modeler.html?modelId=" + modelData.getId());
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("modelId", modelData.getId());
            return new BaseResp<Map<String,Object>>(map);
        } catch (Exception e) {
            logger.error("创建模型失败：", e);
        }
        return new BaseResp<>(ResultStatus.FAIL);
    }
    
    
	/**
	 * 发布模型为流程定义
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "流程设计器--发布模型为流程定义", notes = "流程id", httpMethod = "POST")
	@PostMapping("{id}/deployment")
	public Object deploy(@PathVariable("id") String id) throws Exception {

		// 获取模型
		Model modelData = repositoryService.getModel(id);
		byte[] bytes = repositoryService.getModelEditorSource(modelData.getId());

		if (bytes == null) {
			return BaseResponse.buildResult().status(Status.FAIL).msg("模型数据为空，请先设计流程并成功保存，再进行发布。");
		}

		JsonNode modelNode = new ObjectMapper().readTree(bytes);

		BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
		if (model.getProcesses().size() == 0) {
			return BaseResponse.buildResult().status(Status.FAIL).msg("数据模型不符要求，请至少设计一条主线流程。");
		}
		byte[] bpmnBytes = new BpmnXMLConverter().convertToXML(model);

		// 发布流程
		String processName = modelData.getName() + ".bpmn20.xml";
		Deployment deployment = repositoryService.createDeployment().name(modelData.getName())
				.addString(processName, new String(bpmnBytes, "UTF-8")).deploy();
		modelData.setDeploymentId(deployment.getId());
		repositoryService.saveModel(modelData);

		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	/*
	 * @RequestMapping("/uploadTvType") public void
	 * uploadTvType(HttpServletRequest request,
	 * 
	 * @RequestParam("file") MultipartFile file, HttpServletResponse response)
	 * throws Exception { //该对象为jar中工具类 POIExcelUtil poi = new POIExcelUtil();
	 * poi.impExcelFile(fileName, new UserTypeBean(),inputStream); List<Object>
	 * valueList = poi.getValueList(); if(valueList!=null &&
	 * valueList.size()>0){ for(int i =0;i<valueList.size();i++){
	 * 
	 * UserTypeBean bean = (UserTypeBean)valueList.get(i);
	 * 
	 * //输出字段数据，并插入到相应的表中，省略
	 * 
	 * System.out.println(bean.getTvTypeCode()+"...............");
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

	@Override
	public Object getOne(@PathVariable("id") String id) {
		Model model = repositoryService.createModelQuery().modelId(id).singleResult();
		return BaseResponse.buildResult().setObjData(model);
	}

	/**
	 * 获取所有模型
	 */
	@Override
	@ApiOperation(value = "流程设计器--获取所有模型", notes = "page当前页|rowSize页码", httpMethod = "GET")
	public Object getList(@RequestParam(value = "rowSize", defaultValue = "1000", required = false) Integer rowSize,
			@RequestParam(value = "page", defaultValue = "1", required = false) Integer page) {
		List<Model> list = repositoryService.createModelQuery().list();;

		return new BaseResp<List<Model>>(list);
	}

	/**
	 * 删除模型
	 */
	@ApiOperation(value = "流程设计器--删除模型", notes = "id流程", httpMethod = "GET")
	public Object deleteOne(@PathVariable("id") String id) {
		repositoryService.deleteModel(id);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	@Override
	public Object postOne(@RequestBody Model entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object putOne(@PathVariable("id") String s, @RequestBody Model entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object patchOne(@PathVariable("id") String s, @RequestBody Model entity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 导出model对象为指定类型
	 *
	 * @param modelId
	 *            模型ID
	 * @param type
	 *            导出文件类型(bpmn\json)
	 */
	@GetMapping(value = "export/{modelId}/{type}")
	public void export(@PathVariable("modelId") String modelId, @PathVariable("type") String type,
			HttpServletResponse response) {
		try {
			Model modelData = repositoryService.getModel(modelId);
			BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
			byte[] modelEditorSource = repositoryService.getModelEditorSource(modelData.getId());

			JsonNode editorNode = new ObjectMapper().readTree(modelEditorSource);
			BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);

			// 处理异常
			if (bpmnModel.getMainProcess() == null) {
				response.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
				response.getOutputStream().println("no main process, can't export for type: " + type);
				response.flushBuffer();
				return;
			}

			String filename = "";
			byte[] exportBytes = null;
			String mainProcessId = bpmnModel.getMainProcess().getId();
			if (type.equals("bpmn")) {
				BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
				exportBytes = xmlConverter.convertToXML(bpmnModel);
				filename = mainProcessId + ".bpmn20.xml";
			} else if (type.equals("json")) {
				exportBytes = modelEditorSource;
				filename = mainProcessId + ".json";
			}

			ByteArrayInputStream in = new ByteArrayInputStream(exportBytes);
			IOUtils.copy(in, response.getOutputStream());
			response.setHeader("Content-Disposition", "attachment; filename=" + filename);
			response.flushBuffer();
		} catch (Exception e) {
			logger.error("导出model的xml文件失败：modelId={}, type={}", modelId, type, e);
		}
	}
	
	@PostMapping(value = "/uploadPoster")
	public @ResponseBody Object uploadPoster(HttpServletRequest request, HttpServletResponse response, String base64,
			String fileName) throws Exception {

		System.out.println("开始上传照片");
		String customerId = "";
		String ret_fileName = null;// 返回给前端已修改的图片名称
		String base64Img = base64;
		// 临时文件路径
		// String dirTemp = "\\upload\\temp";
		String dirTemp = "\\upload";
		String uploadImg = "\\upload";
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return new BaseResp<>(ResultStatus.FAIL);
		}
		// response.setContentType("text/html; charset=UTF-8");
		// PrintWriter out = response.getWriter();

		String realPath = request.getServletContext().getRealPath("");
		String tempPath = request.getServletContext().getRealPath("/") + dirTemp;
		File file_normer = new File(realPath + uploadImg + "/" + customerId);
		if (!file_normer.exists()) {
			file_normer.mkdirs();
		}
		// 用于设置图片过大，存入临时文件
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(20 * 1024 * 1024); // 设定使用内存超过5M时，将产生临时文件并存储于临时目录中。
		factory.setRepository(new File(tempPath)); // 设定存储临时文件的目录。

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		// 图像数据为空
		if (base64Img == null) {
			return new BaseResp<>(ResultStatus.FAIL);
		}
		base64Img = base64Img
				.replaceAll("data:application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;base64,", "");
		System.out.println(base64Img);
		logger.info(base64Img);
		ret_fileName = new String((DateHandler.dateToStr(new Date(), "yyyyMMddhhmmss") + ".xlsx").getBytes("gb2312"),
				"ISO8859-1");
		System.out.println(ret_fileName);
		Base64Util.generateFile(base64Img, ret_fileName);
		String image_url = request.getSession().getServletContext().getContextPath() + "/upload/" + customerId + "/"
				+ ret_fileName;
		// 将已修改的图片url对应的id返回前端
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("image_url", image_url);
		return new BaseResp<Map<String, Object>>(map);
	}
}
