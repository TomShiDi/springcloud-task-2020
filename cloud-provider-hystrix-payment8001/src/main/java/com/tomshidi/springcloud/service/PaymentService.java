package com.tomshidi.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author TomShiDi
 * @Since 2020/7/6
 * @Version 1.0
 */
@Service
public class PaymentService {
    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "\tpaymentInfo_OK,id: " + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String paymentInfo_Timeout(Integer id) {
        int timeNumber = 4000;
//        int age = 10 / 0;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_Timeout,id: " + id + "\t" + "耗时" + timeNumber + "";
    }

    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " 系统繁忙或者运行报错，请稍后重试,id: " + id +"\t (；д；)";
    }
}
