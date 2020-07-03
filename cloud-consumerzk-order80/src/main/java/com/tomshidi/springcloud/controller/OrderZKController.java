package com.tomshidi.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author TomShiDi
 * @Since 2020/7/3
 * @Version 1.0
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderZKController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";

    private RestTemplate restTemplate;

    @Autowired
    public OrderZKController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/zk")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }
}
