package com.tomshidi.springcloud.service.impl;

import com.tomshidi.springcloud.dao.AccountDao;
import com.tomshidi.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author TomShiDi
 * @Since 2020/7/18
 * @Version 1.0
 */
@Service
@Slf4j
public class AcountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service扣除账户余额 开始");
        accountDao.decrease(userId, money);
        log.info("------->account-service扣除账户余额 结束");
    }
}
