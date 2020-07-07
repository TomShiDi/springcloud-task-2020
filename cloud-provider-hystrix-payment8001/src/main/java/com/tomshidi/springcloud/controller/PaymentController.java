package com.tomshidi.springcloud.controller;

import com.tomshidi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author TomShiDi
 * @Since 2020/7/6
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(path = "/hystrix/ok")
    public String paymentInfo_OK(@RequestParam(name = "id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("********result:\t{}", result);
        return result;
    }

    @GetMapping("/hystrix/timeout")
    public String paymentInfo_Timeout(@RequestParam(name = "id") Integer id) {
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("********result:\t{}", result);
        return result;
    }

    @GetMapping("/circuit")
    public String paymentCircuitBreaker(@RequestParam(name = "id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*******result: {}", result);
        return result;
    }
}
