package com.tomshidi.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author TomShiDi
 * @Since 2020/7/18
 * @Version 1.0
 */
@Mapper
public interface StorageDao {
    /**
     * 扣减库存
     * @param productId 产品编号
     * @param count 数量
     */
    void decrease(@Param("productId") Long productId,
                  @Param("count") Integer count);
}
