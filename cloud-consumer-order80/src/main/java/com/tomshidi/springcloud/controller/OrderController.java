package com.tomshidi.springcloud.controller;

import com.tomshidi.springcloud.entities.CommonResult;
import com.tomshidi.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author TomShiDi
 * @Since 2020/7/2
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/consumer/order")
public class OrderController {

    private RestTemplate restTemplate;

//    private static final String PAYMENT_URL = "http://localhost:8001";

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment,CommonResult.class);
    }

    @GetMapping("/get")
    public CommonResult getPayment(@RequestParam("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get?id=" + id, CommonResult.class);
        log.info("entityStatus: {}\t,entityHeader: {}\t,entityBody: {}", entity.getStatusCode(), entity.getHeaders(), entity.getBody());
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }else{
            return new CommonResult(555, "操作异常");
        }

//        return restTemplate.getForObject(PAYMENT_URL + "/payment/get?id=" + id, CommonResult.class);
    }
}
