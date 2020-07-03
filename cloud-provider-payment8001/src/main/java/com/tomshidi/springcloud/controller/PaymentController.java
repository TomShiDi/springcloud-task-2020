package com.tomshidi.springcloud.controller;

import com.tomshidi.springcloud.entities.CommonResult;
import com.tomshidi.springcloud.entities.Payment;
import com.tomshidi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author TomShiDi
 * @Since 2020/7/1
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @Autowired
    public PaymentController( PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*******插入结果: " + result);

        if (result > 0) {
            return new CommonResult<>(200, "插入成功 ServerPort: "+serverPort,result);
        }else {
            return new CommonResult<>(555, "插入失败 ServerPort: " + serverPort);
        }

    }

    @GetMapping("/get")
    public CommonResult<Payment> getPaymentById(@RequestParam(name = "id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("*******查询结果: " + result);

        if (result != null) {
            return new CommonResult<>(200, "查询成功 ServerPort: " + serverPort, result);
        } else {
            return new CommonResult<>(555, "没有对应记录，查询id: " + id);
        }
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String item : services) {
            log.info("******service: " + item);
        }

        List<ServiceInstance> instanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : instanceList) {
            log.info("serviceid: {},host: {},port: {},uri: {}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort(), serviceInstance.getUri());
        }
        return this.discoveryClient;
    }
}
