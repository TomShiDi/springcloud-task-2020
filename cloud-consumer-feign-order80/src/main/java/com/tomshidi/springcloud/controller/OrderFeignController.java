package com.tomshidi.springcloud.controller;

import com.tomshidi.springcloud.entities.CommonResult;
import com.tomshidi.springcloud.entities.Payment;
import com.tomshidi.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author TomShiDi
 * @Since 2020/7/5
 * @Version 1.0
 */
@RestController
@RequestMapping()
@Slf4j
public class OrderFeignController {
    private PaymentFeignService paymentFeignService;

    @Autowired
    public OrderFeignController(PaymentFeignService paymentFeignService) {
        this.paymentFeignService = paymentFeignService;
    }

    @GetMapping("/consumer/feign/get")
    public CommonResult<Payment> getPaymentById(@RequestParam(name = "id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/feign/timeout")
    public String paymentFeignTimeout() {
        //openfeign-ribbon 默认等待1秒
        return paymentFeignService.paymentFeignTimeout();
    }
}
