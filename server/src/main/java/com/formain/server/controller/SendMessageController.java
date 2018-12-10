package com.formain.server.controller;

import com.formain.server.dto.OrderDto;
import com.formain.server.message.StreamClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 项目名称：order
 * 包： com.formain.server.controller
 * 类名称：SendMessageController.java
 * 类描述：stream发送消息控制器
 * 创建人：wufuming
 * 创建时间：2018年12月03日
 */
@RestController
@Slf4j
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        log.info("message send:"+Thread.currentThread().getName());
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId("10086");
        streamClient.input().send(MessageBuilder.withPayload(orderDto).build());
        return "ok";
    }

}