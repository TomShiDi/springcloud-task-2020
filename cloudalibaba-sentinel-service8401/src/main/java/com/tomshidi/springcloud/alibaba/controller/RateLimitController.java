package com.tomshidi.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tomshidi.springcloud.alibaba.handlers.CustomerBlockHandler;
import com.tomshidi.springcloud.entities.CommonResult;
import com.tomshidi.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author TomShiDi
 * @Since 2020/7/15
 * @Version 1.0
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerException")
    public CommonResult byResource() {
        return new CommonResult<>(200, "按资源名称限流测试", new Payment(2020L, "serial001"));
    }

    public CommonResult handlerException(BlockException blockException) {
        return new CommonResult(444, blockException.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource("byUrl")
    public CommonResult byUrl() {
        return new CommonResult<>(200, "按url限流测试", new Payment(2020L, "serial002"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult<>(200, "按客户自定义", new Payment(2020L, "serial003"));
    }
}
