package com.tomshidi.springcloud.alibaba.service;

import com.tomshidi.springcloud.entities.CommonResult;
import com.tomshidi.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author TomShiDi
 * @Since 2020/7/17
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回，-----paymentSQL", new Payment(id, "errorSerial"));
    }
}
