package com.tomshidi.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author TomShiDi
 * @Since 2020/7/7
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "--------PaymentFallbackService paymentInfo_OK fall back,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "--------PaymentFallbackService paymentInfo_Timeout fall back,o(╥﹏╥)o";
    }
}
