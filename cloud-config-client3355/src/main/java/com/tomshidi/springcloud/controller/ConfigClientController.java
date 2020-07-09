package com.tomshidi.springcloud.controller;

import com.tomshidi.springcloud.components.ValueComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author TomShiDi
 * @Since 2020/7/8
 * @Version 1.0
 */
@RestController
@RequestMapping("/config")
@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
@Slf4j
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Autowired
    private ValueComponent valueComponent;

    @GetMapping("/configInfo")
    private String getConfigInfo() {
        log.info("********valueComponent: {}", valueComponent.getConfigInfo());
        return configInfo;
    }

    public void setConfigInfo(String configInfo) {
        this.configInfo = configInfo;
    }
}
