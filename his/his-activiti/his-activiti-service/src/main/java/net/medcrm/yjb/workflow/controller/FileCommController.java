package net.medcrm.yjb.workflow.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.dateutil.DateHandler;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.fileutil.Base64Util;
import net.medcrm.yjb.his.fileutil.ZipUtils;
import net.medcrm.yjb.workflow.domain.HflowFormFile;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.service.IHflowFormFileService;
import net.medcrm.yjb.workflow.util.StringUtils;
import net.medcrm.yjb.workflow.vo.FileCommVO;
/**
 * 文件操作类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/file/comm/")
public class FileCommController {
	@Autowired
	private EmployeeServiceClient employeeServiceClient;
	
	@Autowired
	private IHflowFormFileService flowFormFileService;

	@ApiOperation(value = "流程--附件上传", notes = "文件加密成base64位、上传成功后返回附件信息", httpMethod = "POST")
	@ApiImplicitParam(name = "fileComm", value = "文件操类", required = true, dataType = "FileCommVO")
	@PostMapping(value = "/file/upload")
	public Object uploadFile(@RequestBody FileCommVO fileComm) throws IOException {
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		String path = Base64Util.uploadFile(fileComm.getBase64Str());
		if(StringUtils.isNull(path))
			return new BaseResp<>(-1,"上传失败",null);
		HflowFormFile formFile =new HflowFormFile();
		formFile.setContent(fileComm.getDescribe());
		formFile.setFileName(fileComm.getFileName());
		formFile.setCreateUser(user.getFullName());
		formFile.setCreateUserId(user.getId());
		formFile.setDeptName(user.getMajorName());
		formFile.setUrl(path);
		formFile.setBusinessKey(fileComm.getBusinessKey());
		formFile.setBusinessId(fileComm.getBusinessId());
		if(StringUtils.isNull(fileComm.getFileId())) {
			formFile= flowFormFileService.save(formFile);
		}else {
			formFile=flowFormFileService.update(formFile);
		}
		if(StringUtils.isNotNull(formFile)) {
			String path1="http://"+flowFormFileService.getFastDbPath();
			formFile.setUrl(path1+formFile.getUrl());
			formFile.setBusinessKey(fileComm.getBusinessKey());
			formFile.setBusinessId(fileComm.getBusinessId());
		}
		return new BaseResp<>(formFile);
	}
	
	@ApiOperation(value = "流程--删除附件", notes = "删除附件，多个用逗号分开", httpMethod = "POST")
	@ApiImplicitParam(name = "fileIds", value = "附件ID，多个用逗号分开", required = true, dataType = "String")
	@PostMapping(value = "/file/delete")
	public Object deleteFile(String fileIds) {
		if(StringUtils.isNull(fileIds))
			return new BaseResp<>(-1,"附件ID不能为空",null);
		flowFormFileService.deleteFile(fileIds);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}
	
	@ApiOperation(value = "流程--查看附件列表", notes = "查看附件列表", httpMethod = "GET")
	@ApiImplicitParam(name = "processInstanceId", value = "流程实例ID", required = true, dataType = "String")
	@GetMapping(value = "/file/getList")
	public Object findListByForm(String processInstanceId) {
		if(StringUtils.isNull(processInstanceId))
			return new BaseResp<>(-1,"流程执行ID不能为空",null);
		String path1 = "http://" + flowFormFileService.getFastDbPath();
		List<HflowFormFile> list=flowFormFileService.findListByProcessInstanceId(processInstanceId);
		ArrayList<HflowFormFile> result = Lists.newArrayList();
		for (HflowFormFile hflowFormFile : list) {
			hflowFormFile.setUrl(path1+hflowFormFile.getUrl());
			result.add(hflowFormFile);
		}
		return new BaseResp<>(result);
	}
	
	
	/**
     * 打包压缩下载文件
	 * @throws IOException 
     */
	@ApiOperation(value = "流程--打包压缩下载文件", notes = "打包压缩下载文件，多个用逗号分开", httpMethod = "GET")
	@ApiImplicitParam(name = "fileIds", value = "附件id,多个用逗号分开", required = true, dataType = "String")
    @RequestMapping(value = "/file/downLoadZipFile")
    public Object downLoadZipFile(String fileIds, HttpServletResponse response) throws IOException{
        String zipName = "flowfile.zip";
        List<HflowFormFile> fileList = flowFormFileService.findListByPrimaryKeys(fileIds);//查询数据库中记录
        if(StringUtils.isNull(fileList))
        	return new BaseResp<>(-1,"文件下载出错",null);
        response.setContentType("APPLICATION/OCTET-STREAM");  
        response.setHeader("Content-Disposition","attachment; filename="+zipName);
        ZipOutputStream out = new ZipOutputStream(response.getOutputStream());
        String path="http://"+flowFormFileService.getFastDbPath();
        try {
        	File[] files= new File[fileList.size()]; 
        	for(int i=0;i<fileList.size();i++) {
        		HflowFormFile hflowFormFile=fileList.get(i);
        		//String fileName=hflowFormFile.getFileName()+"."+hflowFormFile.getFileType();
        		String fileName=hflowFormFile.getFileName();
        		String str=new String((DateHandler.dateToStr2(new Date(), "yyyyMMddhhmmssSSS")).getBytes("gb2312"),
						"ISO8859-1");
        		ZipUtils.downLoadFromUrl(path+hflowFormFile.getUrl(),fileName,Base64Util.getLoadFilePath()+File.separator+str);
        		files[i]=new File(Base64Util.getLoadFilePath()+str+File.separator+fileName);
      		}
        	ZipUtils.getDownload(files, out);
        	response.flushBuffer();
        } catch (IOException e) {
        	e.printStackTrace();
        }finally{
            out.close();
        }
        return new BaseResp<>();
    }
	
	@ApiOperation(value = "图片上传--图片、图标", notes = "图片加密成base64位、上传成功后返回图片路经", httpMethod = "POST")
	@ApiImplicitParam(name = "fileComm", value = "文件操类", required = true, dataType = "FileCommVO")
	@PostMapping(value = "/picture/upload")
	public Object uploadPosterImg(@RequestBody FileCommVO fileComm) throws IOException {
		String path = flowFormFileService.saveImg(fileComm);
		if(StringUtils.isNull(path))
			return new BaseResp<>(-1,"上传失败",null);
		return new BaseResp<>(path);
	}
	
	@ApiOperation(value = "文件上传--图片、图标不归档的文件", notes = "文件加密成base64位、上传成功后返回文件名", httpMethod = "POST")
	@ApiImplicitParam(name = "fileComm", value = "文件操类", required = true, dataType = "FileCommVO")
	@PostMapping(value = "/ico/upload")
	public Object uploadPoster(@RequestBody FileCommVO fileComm) {
		String path = Base64Util.uploadFile(fileComm.getBase64Str());
		if(StringUtils.isNull(path))
			return new BaseResp<>(-1,"上传失败",null);
		return new BaseResp<>(path);
	}
	
	
	 
}
