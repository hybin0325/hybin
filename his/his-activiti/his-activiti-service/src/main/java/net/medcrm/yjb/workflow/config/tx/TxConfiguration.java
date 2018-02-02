package net.medcrm.yjb.workflow.config.tx;

import com.lorne.tx.springcloud.feign.TransactionRestTemplateInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2017/11/18.
 */
public class TxConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor(){
        return new TransactionRestTemplateInterceptor();
    }
}
