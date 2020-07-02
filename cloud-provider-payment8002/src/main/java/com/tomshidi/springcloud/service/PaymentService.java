package com.tomshidi.springcloud.service;

import com.tomshidi.springcloud.entities.Payment;

/**
 * @Author TomShiDi
 * @Since 2020/7/1
 * @Version 1.0
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
