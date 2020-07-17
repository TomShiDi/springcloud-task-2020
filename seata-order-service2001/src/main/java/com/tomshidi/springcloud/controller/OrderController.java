package com.tomshidi.springcloud.controller;

import com.tomshidi.springcloud.domain.CommonResult;
import com.tomshidi.springcloud.domain.Order;
import com.tomshidi.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author TomShiDi
 * @Since 2020/7/17
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/order")
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;

    @PostMapping(value = "/create")
    public CommonResult<Order> create(Order order) {
        orderService.create(order);
        return new CommonResult<>(200, "订单创建成功", null);
    }
}
