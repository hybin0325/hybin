package com.edas.edascommon.autoconfigure;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuyadu
 */
//@Configuration
public  class MqAutoConfiguration {
    public static final String QUEUE_API_RESOURCE = "queue.api.resource";
    public static final String QUEUE_API_RESOURCE_LIMIT = "queue.api.resource.limit";

    /**
     * direct模式，直接根据队列名称投递消息
     *
     * @return
     */
    @Bean
    public Queue apiResourceQueue() {
        return new Queue(QUEUE_API_RESOURCE);
    }

    @Bean
    public Queue apiResourceLimitQueue() {
        return new Queue(QUEUE_API_RESOURCE_LIMIT);
    }

}