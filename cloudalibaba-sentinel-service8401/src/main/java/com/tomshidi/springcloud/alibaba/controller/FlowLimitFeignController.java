package com.tomshidi.springcloud.alibaba.controller;

import com.tomshidi.springcloud.alibaba.service.FlowLimitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author TomShiDi
 * @Since 2020/7/14
 * @Version 1.0
 */
@RestController
@RequestMapping("/feign")
@Slf4j
public class FlowLimitFeignController {
    @Resource
    private FlowLimitService flowLimitService;

    @GetMapping("/testA")
    @ResponseBody
    public String testA() {
        return flowLimitService.testA();
    }

    @GetMapping("/testB")
    @ResponseBody
    public String testB() {
        return flowLimitService.testB();
    }
}
