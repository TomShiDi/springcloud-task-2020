package com.tomshidi.springcloud.controller;

import com.tomshidi.springcloud.domain.Account;
import com.tomshidi.springcloud.domain.CommonResult;
import com.tomshidi.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author TomShiDi
 * @Since 2020/7/18
 * @Version 1.0
 */
@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping("/decrease")
    public CommonResult<Account> decrease(@RequestParam(name = "userId") Long userId,
                                          @RequestParam(name = "money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult<>(200, "扣减账户余额成功", null);
    }
}
