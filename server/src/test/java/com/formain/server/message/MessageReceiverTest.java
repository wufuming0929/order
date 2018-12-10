package com.formain.server.message;

import com.formain.server.ServerApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class MessageReceiverTest extends ServerApplicationTests{

    @Autowired
    private AmqpTemplate template;

    @Test
    public void send() {
        template.convertAndSend("myOrder","computer","this is computer order message!");
        template.convertAndSend("myOrder","fruit","this is fruit order message!");
    }

}