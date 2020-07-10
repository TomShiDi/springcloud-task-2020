package com.tomshidi.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author TomShiDi
 * @Since 2020/7/10
 * @Version 1.0
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者 {} ,接收到的消息--------> {}", serverPort, message.getPayload());

    }
}
