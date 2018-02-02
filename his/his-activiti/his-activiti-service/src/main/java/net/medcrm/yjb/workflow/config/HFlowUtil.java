package net.medcrm.yjb.workflow.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 一些工具bean
 */
@Configuration
public class HFlowUtil {


    //jackson xml util
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
