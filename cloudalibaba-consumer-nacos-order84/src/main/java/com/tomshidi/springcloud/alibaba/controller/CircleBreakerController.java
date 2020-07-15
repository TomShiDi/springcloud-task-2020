package com.tomshidi.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tomshidi.springcloud.entities.CommonResult;
import com.tomshidi.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author TomShiDi
 * @Since 2020/7/15
 * @Version 1.0
 */
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/fallback")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")//fallback负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")//配置sentinel限流
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")//同时配置，blockHandler优先
    @SuppressWarnings("unchecked")
    public CommonResult<Payment> fallback(@RequestParam(name = "id") Long id) {
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL?id=" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常......");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该id没有对应记录，空指针异常");
        }

        return result;
    }

    public CommonResult handlerFallback(Long id, Throwable throwable) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "兜底方法handlerFallback,exception内容: " + throwable.getMessage(), payment);
    }

    public CommonResult blockHandler(Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "blockHandler-sentinel限流，无此流水号,blockException: " + blockException.getMessage(), payment);
    }
}
