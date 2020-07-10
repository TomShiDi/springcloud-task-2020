package com.tomshidi.springcloud.controller;

import com.tomshidi.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author TomShiDi
 * @Since 2020/7/10
 * @Version 1.0
 */
@RestController
@RequestMapping("/provider")
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public String sendMessage() {
        return messageProvider.send();
    }
}
