package com.formain.server.controller;

import com.formain.server.config.GirlConfig;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称：order
 * 包： com.formain.server.controller
 * 类名称：EnvController.java
 * 类描述：env测试
 * 创建人：wufuming
 * 创建时间：2018年11月24日
 */
@RestController
//@RefreshScope
public class EnvController {

    @Value("${env}")
    private String env;

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("girl/print")
    public String print(){
        return "name:"+girlConfig.getName()+" age:"+girlConfig.getAge();
    }
}