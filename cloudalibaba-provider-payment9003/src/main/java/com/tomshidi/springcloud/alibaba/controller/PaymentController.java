package com.tomshidi.springcloud.alibaba.controller;

import com.tomshidi.springcloud.entities.CommonResult;
import com.tomshidi.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author TomShiDi
 * @Since 2020/7/15
 * @Version 1.0
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static Map<Long, Payment> map = new HashMap<>();

    static {
        map.put(1L, new Payment(1L, "7d7f1435792c4273a2cdc441dc3edb01"));
        map.put(2L, new Payment(2L, "7d7f1435792c4273a2cdc441dc3edb02"));
        map.put(3L, new Payment(3L, "7d7f1435792c4273a2cdc441dc3edb03"));
    }

    @GetMapping("/paymentSQL")
    public CommonResult<Payment> paymentSQL(@RequestParam(name = "id") Long id) {
        Payment payment = map.get(id);
//        try {
//            TimeUnit.SECONDS.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql,serverPort: " + serverPort, payment);
        return result;
    }
}
