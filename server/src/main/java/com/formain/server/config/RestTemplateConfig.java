package com.formain.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 项目名称：order
 * 包： com.formain.order.config
 * 类名称：RestTemplateConfig.java
 * 类描述：配置RestTemplate类
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
@Component
public class RestTemplateConfig {

    @Bean
    //@LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}