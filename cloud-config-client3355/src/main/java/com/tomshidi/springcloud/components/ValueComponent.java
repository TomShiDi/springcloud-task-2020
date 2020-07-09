package com.tomshidi.springcloud.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author TomShiDi
 * @Since 2020/7/8
 * @Version 1.0
 */
@Component
@RefreshScope
public class ValueComponent {
    @Value("${config.info}")
    private String configInfo;

    public String getConfigInfo() {
        return configInfo;
    }

    public void setConfigInfo(String configInfo) {
        this.configInfo = configInfo;
    }
}
