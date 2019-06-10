package com.edas.edasgateway.component;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = Lists.newArrayList();
		resources.add(swaggerResource("用户服务", "/api-user/v2/api-docs", "2.0"));
		resources.add(swaggerResource("消息服务", "/api-msg/v2/api-docs", "2.0"));
		resources.add(swaggerResource("权限认证服务", "/api-auth/v2/api-docs", "2.0"));
		resources.add(swaggerResource("钉钉服务", "/api-dingtalk/v2/api-docs", "2.0"));
		resources.add(swaggerResource("业务处理服", "/api-bdata/v2/api-docs", "2.0"));
		resources.add(swaggerResource("电话语音服务", "/api-byrobot/v2/api-docs", "2.0"));
		resources.add(swaggerResource("微信服务", "/api-wechat/v2/api-docs", "2.0"));
		
		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}
