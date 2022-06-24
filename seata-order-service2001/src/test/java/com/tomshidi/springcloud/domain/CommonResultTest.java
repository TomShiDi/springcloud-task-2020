package com.tomshidi.springcloud.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author tangshili
 * @date 2022/6/24 15:23
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonResultTest {

    @Test
    public void getCode() {
        new CommonResult<String>().getCode();
    }

    @Test
    public void setCode() {
        new CommonResult<String>().setCode(1);
    }

    @Test
    public void getMessage() {
        new CommonResult<String>().getMessage();
    }

    @Test
    public void setMessage() {
        new CommonResult<String>().setMessage("1");
    }

    @Test
    public void getData() {
        new CommonResult<String>().getData();
    }

    @Test
    public void setData() {
        new CommonResult<String>().setData("1");
    }
}