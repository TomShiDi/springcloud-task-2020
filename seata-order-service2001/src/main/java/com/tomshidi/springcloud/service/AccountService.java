package com.tomshidi.springcloud.service;

import com.tomshidi.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author TomShiDi
 * @Since 2020/7/17
 * @Version 1.0
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    /**
     * 远程服务调用 库存减
     * @param userId 用户编号
     * @param money 钱数
     * @return
     */
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam(name = "userId") Long userId,
                          @RequestParam(name = "money") BigDecimal money);
}
