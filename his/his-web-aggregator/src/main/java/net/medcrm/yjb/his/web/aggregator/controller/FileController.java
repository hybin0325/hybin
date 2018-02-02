package net.medcrm.yjb.his.web.aggregator.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.dateutil.DateHandler;
import net.medcrm.yjb.his.fileutil.Base64Util;

@RestController
@CrossOrigin
@RequestMapping("/api/file")
public class FileController {
	/**
	 * 文件上传
	 *
	 * @param request
	 * @param response
	 * @param base64
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/uploadPoster")
	public @ResponseBody Object uploadPoster(HttpServletRequest request, HttpServletResponse response,
			String fileBase64, String fileName) throws Exception {
		String customerId = "";
		String ret_fileName = null;// 返回给前端已修改的图片名称
		// 临时文件路径
		// String dirTemp = "\\upload\\temp";
		String dirTemp = "\\upload";
		String uploadImg = "\\upload";
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			return new BaseResp<>(ResultStatus.error_file_upload);
		}
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
		if (fileBase64 == null) // 图像数据为空
			return false;
		fileBase64 = fileBase64.replaceAll("data:image/jpeg;base64,", "");
		ret_fileName = new String((DateHandler.dateToStr(new Date(), "yyyyMMddhhmmss") + ".jpg").getBytes("gb2312"),
				"ISO8859-1");
		// Base64解码
		Base64Util.generateFile(fileBase64, ret_fileName);
		String image_url = request.getSession().getServletContext().getContextPath() + "/upload/" + customerId + "/"
				+ ret_fileName;
		// 将已修改的图片url对应的id返回前端
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("image_url", image_url);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

}
