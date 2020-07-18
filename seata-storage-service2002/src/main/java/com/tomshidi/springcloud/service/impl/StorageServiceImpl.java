package com.tomshidi.springcloud.service.impl;

import com.tomshidi.springcloud.dao.StorageDao;
import com.tomshidi.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author TomShiDi
 * @Since 2020/7/18
 * @Version 1.0
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("----->storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("----->storage-service中扣减库存结束");
    }
}
