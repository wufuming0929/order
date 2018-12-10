package com.formain.server.message;

import com.formain.server.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 项目名称：order
 * 包： com.formain.server.message
 * 类名称：StreamReceiver.java
 * 类描述：stream消息监听
 * 创建人：wufuming
 * 创建时间：2018年12月03日
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(StreamClient.INPUT)
    //@SendTo(StreamClient.INPUT2)
    public void process(OrderDto message) {
        log.info("message receiver:" + Thread.currentThread().getName());
        log.info("message--->" + message + "<---");
        //return "receive";
    }

    @StreamListener(StreamClient.INPUT2)
    public void receive(String receive) {
        log.info("receive:" + receive);
    }


}