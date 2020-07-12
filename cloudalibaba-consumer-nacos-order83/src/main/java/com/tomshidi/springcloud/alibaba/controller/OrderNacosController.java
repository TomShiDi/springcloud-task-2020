package com.tomshidi.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author TomShiDi
 * @Since 2020/7/11
 * @Version 1.0
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping(value = "/nacos")
    public String paymentInfo(@RequestParam(name = "id") Integer id) {
        return restTemplate.getForObject(serverUrl + "/payment/nacos?id=" + id, String.class);
    }
}
