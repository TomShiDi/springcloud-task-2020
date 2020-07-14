package com.tomshidi.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author TomShiDi
 * @Since 2020/7/14
 * @Version 1.0
 */
@Component
@FeignClient(value = "cloudalibaba-sentinel-service")
public interface FlowLimitService {
    @GetMapping("/testA")
    public String testA();

    @GetMapping("/testB")
    public String testB();
}
