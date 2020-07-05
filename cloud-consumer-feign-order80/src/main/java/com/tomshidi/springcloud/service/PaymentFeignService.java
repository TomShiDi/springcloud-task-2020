package com.tomshidi.springcloud.service;

import com.tomshidi.springcloud.entities.CommonResult;
import com.tomshidi.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author TomShiDi
 * @Since 2020/7/5
 * @Version 1.0
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    /**
     * 这里的Mapping保持和提供方一致
     * @param id 编号
     * @return 查询结果通用实体
     */
    @GetMapping("/payment/get")
    public CommonResult<Payment> getPaymentById(@RequestParam(name = "id") Long id);

    @GetMapping(value = "/payment/timeout")
    public String paymentFeignTimeout();
}
