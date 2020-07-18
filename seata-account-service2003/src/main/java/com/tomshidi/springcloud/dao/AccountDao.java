package com.tomshidi.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author TomShiDi
 * @Since 2020/7/18
 * @Version 1.0
 */
@Mapper
public interface AccountDao {

    /**
     * 扣账户余额
     * @param userId 账户编号
     * @param money 金额
     */
    void decrease(@Param("userId") Long userId,
                  @Param("money") BigDecimal money);
}
