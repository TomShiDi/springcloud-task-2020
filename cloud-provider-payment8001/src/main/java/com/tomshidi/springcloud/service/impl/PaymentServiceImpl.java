package com.tomshidi.springcloud.service.impl;

import com.tomshidi.springcloud.dao.PaymentDao;
import com.tomshidi.springcloud.entities.Payment;
import com.tomshidi.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author TomShiDi
 * @Since 2020/7/1
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentDao paymentDao;

    @Autowired
    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
