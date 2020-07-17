package com.tomshidi.springcloud.alibaba.service;

import com.tomshidi.springcloud.entities.CommonResult;
import com.tomshidi.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author TomShiDi
 * @Since 2020/7/17
 * @Version 1.0
 */
@Component
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL")
    public CommonResult<Payment> paymentSQL(@RequestParam("id") Long id);
}
