package com.tomshidi.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author TomShiDi
 * @Since 2020/7/3
 * @Version 1.0
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/zk")
    public String paymentZK() {
        return "springcloud with zookeeper : " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
