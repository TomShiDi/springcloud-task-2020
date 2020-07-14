package com.tomshidi.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tomshidi.springcloud.alibaba.service.FlowLimitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author TomShiDi
 * @Since 2020/7/14
 * @Version 1.0
 */
@Controller
//@RequestMapping()
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    @ResponseBody
    public String testA() {
        log.info(Thread.currentThread().getName() + "\t" + "......testA");
        return "**************testA";
//        return flowLimitService.testA();
    }

    @GetMapping("/testB")
    @ResponseBody
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "......testB");
        return "**************testB";
//        return flowLimitService.testB();
    }

    @GetMapping("/testC")
    public String testC() {
        return "redirect:testB";
    }

    @GetMapping("/testD")
    @ResponseBody
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "**********testD";
    }

    @GetMapping("/testHotKey")
    @ResponseBody
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(name = "p1", required = false) String p1,
                             @RequestParam(name = "p2", required = false) String p2) {
        return "***********testHotKey";
    }

    public String dealTestHotKey(String p1, String p2, BlockException blockException) {
        return "***********dealTestHotKey,o(╥﹏╥)o";
    }
}
