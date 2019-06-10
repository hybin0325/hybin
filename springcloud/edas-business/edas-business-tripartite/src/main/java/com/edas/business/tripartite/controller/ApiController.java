package com.edas.business.tripartite.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.edas.business.tripartite.entity.robot.XyRecord;
import com.edas.business.tripartite.service.robot.CallDetailService;
import com.edas.business.tripartite.service.robot.CallRecordService;
import com.edas.business.tripartite.service.robot.CallResultService;
import com.edas.business.tripartite.service.robot.CompanyService;
import com.edas.business.tripartite.service.robot.PhoneTaskService;
import com.edas.business.tripartite.service.robot.XyRecordService;
import com.edas.edascommon.utils.DateUtils;
import com.edas.edascommon.utils.web.RetResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * Description: 无需验证的接口
 * </p>
 * <p>
 * Date：2019年5月16日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Api(tags = "open-apis", description = "第三方调用-apis")
@RestController
@RequestMapping("/api")
public class ApiController {
	
	private final static String SUCCESS = "success";
	
	@Autowired
	private CallDetailService callDetailsService;

	@Autowired
	private PhoneTaskService phoneTaskService;

	@Autowired
	private CallResultService callResultService;

	@Autowired
	private XyRecordService recordService;

	@Autowired
	private CallRecordService callRecordService;
	
	@Autowired
	private CompanyService companyService;
	
	@ApiOperation(value = "获取公司列表", notes = "获取公司列表")
	@GetMapping(value = "/company")
	public Object getCompany() {			
		return RetResponse.makeOKRsp(companyService.selectAll());
	}
	
	/**
	 * 
	 * @Description: 通话详情回调接口
	 *
	 * @param object
	 * @return RetResult
	 *
	 * @date 2019年5月5日
	 * @author zzw
	 */
	@ApiOperation(value = "通话详情回调", notes = "通话详情回调")
	@ApiImplicitParam(name = "param", value = "JSONObject", dataType = "JSONObject")
	@PostMapping(value = "/callDetail")
	public String callDetailCallBack(@RequestBody JSONObject param) throws Exception {
		callDetailsService.handlerCallBack(param);
		return SUCCESS;
	}

	/**
	 * 
	 * @Description: 任务回调接口
	 *
	 * @param param
	 * @return RetResult
	 *
	 * @date 2019年5月5日
	 * @author zzw
	 */
	@ApiOperation(value = "任务回调", notes = "任务回调")
	@ApiImplicitParam(name = "param", value = "JSONObject", dataType = "JSONObject")
	@PostMapping(value = "/task")
	public String taskCallBack(@RequestBody JSONObject param) throws Exception {
		phoneTaskService.handlerCallBack(param);
		return SUCCESS;
	}

	/**
	 * 
	 * @Description: 手动修改客户意向等级回调接口
	 *
	 * @param param
	 * @return RetResult
	 *
	 * @date 2019年5月9日
	 * @author zzw
	 */
	@ApiOperation(value = "修改客户意向等级回调", notes = "修改客户意向等级回调")
	@ApiImplicitParam(name = "param", value = "JSONObject", dataType = "JSONObject")
	@PostMapping(value = "/callResult")
	public String resultCallBack(@RequestBody JSONObject param) throws Exception {
		callResultService.handlerCallBack(param);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Description: 先锋音讯消息回调接口
	 *
	 * @param request，response
	 * @return RetResult
	 *
	 * @date 2019年5月14日
	 * @author zzw
	 */
	@ApiOperation(value = "先锋音讯消息回调接口", notes = "先锋音讯消息回调接口")	
	@PostMapping(value = "/recordNew")
	public String news(HttpServletRequest request,HttpServletResponse response) throws Exception {
		int event_type = Integer.parseInt(request.getParameter("event_type"));		
		//event_type=9表示一条新的去电录音产生event_type=10表示一条新的来电录音产生
		if(event_type == 9 || event_type == 10) {
			int duration = Integer.parseInt(request.getParameter("duration"));
	        Long deviceId = Long.valueOf(request.getParameter("device_id"));	        
	        String caller = request.getParameter("caller");
	        Date date = DateUtils.parseDate(request.getParameter("date"));
	        String fileName = request.getParameter("FilePath");
	        XyRecord record = new XyRecord();
	        record.setCaller(caller);
	        record.setDuration(duration);
	        record.setDeviceId(deviceId);
	        record.setDate(date);
	        record.setFileName(fileName);
	        recordService.handleCallBack(record,null);
		}				
		//response.getWriter().write("0000");
		return "0000";				
	}
	
	/**
	 * 
	 * @Description: 先锋音讯录音文件回调接口
	 * @param request，response
	 */
	@ApiOperation(value = "先锋音讯录音文件回调接口", notes = "先锋音讯录音文件回调接口")	
	@PostMapping(value = "/record")
	public String xyRecord(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		if(ServletFileUpload.isMultipartContent(request)) {			
			MultipartFile file = ((MultipartHttpServletRequest) request).getFile("files");
			if (!file.isEmpty()) {				
				recordService.handleCallBack(null,file);			
			}
		}	
		//response.getWriter().write("0000");
		return "0000";
	}

	/**
	 * 
	 * @Description 上传录音
	 * @param file
	 *
	 */
	@ApiOperation(value = "上传录音", notes = "上传录音")
	@ApiImplicitParam(name = "file", value = "录音文件", dataType = "MultipartFile")
	@PostMapping(value = "/upload")
	public Object upload(HttpServletRequest request) throws Exception {
		if(ServletFileUpload.isMultipartContent(request)) {			
			MultipartFile file = ((MultipartHttpServletRequest) request).getFile("upload");
			if (file.isEmpty()) {
				return RetResponse.makeErrRsp("文件不能为空");
			}
			return callRecordService.uploadRecord(file);
		}
		return RetResponse.makeErrRsp("请求失败");
	}

	/**
	 * 
	 * @Description 下载录音
	 *
	 * @param file
	 * @return RetResult
	 *
	 * @date 2019年5月14日
	 * @author zzw
	 */
	/*@ApiOperation(value = "下载录音", notes = "下载录音")
	@ApiImplicitParam(name = "request", value = "request", dataType = "MultipartFile")
	@GetMapping(value = "/download")
	public void downLoad(String fileName, HttpServletRequest request, HttpServletResponse res) throws Exception {
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			CallRecord downLoadRecord = callRecordService.downLoadRecord(fileName);
			byte[] base64Dcode = ByUtils.base64Dcode(downLoadRecord.getSoundFile());
			bis = new BufferedInputStream(new ByteArrayInputStream(base64Dcode));
			os = res.getOutputStream();
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}*/
	    
}