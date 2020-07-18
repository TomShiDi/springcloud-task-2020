package com.tomshidi.springcloud.service;

import com.tomshidi.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author TomShiDi
 * @Since 2020/7/17
 * @Version 1.0
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    /**
     * 远程服务调用 库存减
     * @param productId 产品编号
     * @param count 数量
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam(name = "productId") Long productId,
                          @RequestParam(name = "count") Integer count);
}
