package com.edas.business.tripartite.configurer;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * Description: 上传文件配置类
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Configuration
public class UploadConfig {
	/**
	 * 配置上传文件大小的配置
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
	   MultipartConfigFactory factory = new MultipartConfigFactory();
	   //  单个数据大小
	   factory.setMaxFileSize("102400KB");
	   /// 总上传数据大小
	   factory.setMaxRequestSize("102400KB");
	   return factory.createMultipartConfig();
	}
}