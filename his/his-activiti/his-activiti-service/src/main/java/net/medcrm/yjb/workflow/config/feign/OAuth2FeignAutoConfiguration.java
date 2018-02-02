/**
 * Copyright (c) 2015 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.medcrm.yjb.workflow.config.feign;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

/**
 * Created by beaver on 2017/6/3.
 */
@Configuration
public class OAuth2FeignAutoConfiguration {
    
    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor(@Qualifier("practiceOAuth2RestTemplate") OAuth2RestTemplate oAuth2RestTemplate) {
        return new OAuth2FeignRequestInterceptor(oAuth2RestTemplate);
    }
}