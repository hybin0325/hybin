package com.edas.system.common.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.servlet.HandlerInterceptor;

import com.edas.system.common.configuration.SpingJwtProperties;
import com.edas.system.common.model.CurrentUser;
import com.edas.system.common.model.UserContext;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;


/**
 * 用户信息拦截器
 * 从Header中取出jwttoken，并获取其中的用户名设置到用户信息上下文线程变量中
 *
 * @author hybin
 */
@Slf4j
@ConfigurationProperties(prefix = "spring.security.oauth2.jwt")
public class UserInfoInterceptor implements HandlerInterceptor {
	
	//@Autowired
	//private SpingJwtProperties jwtProperties;
	@JsonIgnore
	private String signingKey;

	public String getSigningKey() {
		return signingKey;
	}

	public void setSigningKey(String signingKey) {
		this.signingKey = signingKey;
	}
   
	
	static final String SECRET = "123456"; // JWT密码
	static final String TOKEN_PREFIX = "Bearer"; // Token前缀
	static final String HEADER_STRING = "Authorization";// 存放Token的Header Key
   // private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	 log.info("++++++++++++++++++++++++"+signingKey);
        String header = request.getHeader(HEADER_STRING);
        String token = StringUtils.substringAfter(header, TOKEN_PREFIX);
        log.info("++++++++++++++++++++++++"+token);
        if (StringUtils.isNotBlank(token)) {
            //Jwt decode = JwtHelper.decode(token);
            //验签
            //Jwt secretKey = JwtHelper.decodeAndVerify(authorization, new MacSigner("secretKey"));
            //String claims = decode.getClaims();
            //
           // HashMap<String, Object> hashMap = objectMapper.readValue(claims, HashMap.class);
        	Claims claims;
    		try {
    			claims = Jwts.parser().setSigningKey(SECRET.getBytes("UTF-8")).parseClaimsJws(token).getBody();
    		} catch (Exception e) {
    			return false;
    		}
            String username = (String)claims.get("username");
            log.info("username++++++++++++++++++++++++"+username);
            String name =  (String)claims.get("name");
            Object authorities = claims.get("authorities");
            UserContext.setUserInfo(CurrentUser.builder().name(name).username(username).authorities(authorities).build());
        }
        return true;
    }
}
