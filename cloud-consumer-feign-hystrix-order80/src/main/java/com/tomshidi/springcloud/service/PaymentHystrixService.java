package com.tomshidi.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author TomShiDi
 * @Since 2020/7/6
 * @Version 1.0
 */
@Component
@FeignClient(name = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {
    @GetMapping(path = "/payment/hystrix/ok")
    public String paymentInfo_OK(@RequestParam(name = "id") Integer id);

    @GetMapping("/payment/hystrix/timeout")
    public String paymentInfo_Timeout(@RequestParam(name = "id") Integer id);
}
