package com.tomshidi.springcloud.service;

/**
 * @Author TomShiDi
 * @Since 2020/7/18
 * @Version 1.0
 */
public interface StorageService {
    /**
     * 扣减库存
     * @param productId 产品编号
     * @param count 数量
     */
    void decrease(Long productId, Integer count);
}
