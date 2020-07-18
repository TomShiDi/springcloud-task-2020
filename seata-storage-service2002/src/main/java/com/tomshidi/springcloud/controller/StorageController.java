package com.tomshidi.springcloud.controller;

import com.tomshidi.springcloud.domain.CommonResult;
import com.tomshidi.springcloud.domain.Storage;
import com.tomshidi.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author TomShiDi
 * @Since 2020/7/18
 * @Version 1.0
 */
@RestController
@RequestMapping("/storage")
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping("/decrease")
    public CommonResult<Storage> decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult<Storage>(200, "扣减库存成功", null);
    }
}
