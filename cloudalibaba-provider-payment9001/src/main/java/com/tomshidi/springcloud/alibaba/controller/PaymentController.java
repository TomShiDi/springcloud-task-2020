package com.tomshidi.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author TomShiDi
 * @Since 2020/7/11
 * @Version 1.0
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/nacos")
    public String getPayment(@RequestParam(name = "id") Integer id) {
        return "nacos registry,serverPort: " + serverPort + "\t id: " + id;
    }
}
