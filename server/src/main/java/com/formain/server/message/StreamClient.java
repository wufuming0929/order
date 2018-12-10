package com.formain.server.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 项目名称：order
 * 包： com.formain.server.message
 * 类名称：StreamClient.java
 * 类描述：stream客户端
 * 创建人：wufuming
 * 创建时间：2018年12月03日
 */
public interface StreamClient {

    String INPUT = "myMessage";
    String INPUT2 = "myMessage2";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Input(StreamClient.INPUT2)
    SubscribableChannel input2();

}
