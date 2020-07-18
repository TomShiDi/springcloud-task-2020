package com.tomshidi.springcloud.service;

import java.math.BigDecimal;

/**
 * @Author TomShiDi
 * @Since 2020/7/18
 * @Version 1.0
 */
public interface AccountService {
    /**
     * 账户余额扣减
     * @param userId 账户编号
     * @param money 金额
     */
    void decrease(Long userId, BigDecimal money);
}
