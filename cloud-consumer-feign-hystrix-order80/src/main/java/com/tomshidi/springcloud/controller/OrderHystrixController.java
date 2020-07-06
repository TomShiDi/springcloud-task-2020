package com.tomshidi.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tomshidi.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author TomShiDi
 * @Since 2020/7/6
 * @Version 1.0
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(path = "/hystrix/ok")
    public String paymentInfo_OK(@RequestParam(name = "id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

//    @GetMapping("/hystrix/timeout")
//    public String paymentInfo_Timeout(@RequestParam(name = "id") Integer id) {
//        return paymentHystrixService.paymentInfo_Timeout(id);
//    }

    @GetMapping("/hystrix/timeout")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")})
    @HystrixCommand
    public String paymentInfo_Timeout(Integer id) {
        String result = paymentHystrixService.paymentInfo_Timeout(id);
        return result;
    }

    public String paymentInfoTimeoutHandler(Integer id) {
        return "消费者80: 对方支付系统繁忙或者自己运行出错,o(╥﹏╥)o";
    }

    public String paymentGlobalFallbackMethod() {
        return "消费者80: 全局fallback方法 对方支付系统繁忙或者自己运行出错,o(╥﹏╥)o";
    }
}
