package com.formain.server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 项目名称：order
 * 包： com.formain.server.config
 * 类名称：GirlConfig.java
 * 类描述：
 * 创建人：wufuming
 * 创建时间：2018年11月25日
 */
@Data
@Component
@ConfigurationProperties(prefix = "girl")
@RefreshScope
public class GirlConfig {

    private String name;
    private Integer age;

}