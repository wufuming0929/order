package com.formain.server.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 项目名称：order
 * 包： com.formain.server.message
 * 类名称：MessageReceiver.java
 * 类描述：消息接收者
 * 创建人：wufuming
 * 创建时间：2018年12月03日
 */
@Component
public class MessageReceiver {

    /**
     * ①需要先定义队列的名字,否则会报错！
     *
     * @RabbitListener(queues = "my-queue")
     * ②自动创建队列,跟版本有关系,早期版本没有这个属性
     * @RabbitListener(queuesToDeclare =@Queue("my-queue"))
     * ③采用exchange分发消息(即一对多消息)
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
    ))
    public void computerOrderProcess(String message) {
        System.out.println("computer order message→" + message + "←");
    }
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
    ))
    public void fruitOrderProcess(String message) {
        System.out.println("fruit order message→" + message + "←");
    }


}