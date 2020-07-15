package com.tomshidi.springcloud.alibaba.handlers;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tomshidi.springcloud.entities.CommonResult;

/**
 * @Author TomShiDi
 * @Since 2020/7/15
 * @Version 1.0
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException blockException) {
        return new CommonResult<>(4444, "按客户自定义,global handlerException ------1");
    }

    public static CommonResult handlerException2(BlockException blockException) {
        return new CommonResult<>(4444, "按客户自定义,global handlerException -----2");
    }

}
