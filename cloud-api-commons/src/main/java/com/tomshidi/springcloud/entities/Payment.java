package com.tomshidi.springcloud.entities;

import java.io.Serializable;

/**
 * @Author TomShiDi
 * @Since 2020/7/1
 * @Version 1.0
 */
public class Payment implements Serializable {
    private Long id;

    private String serial;

    public Payment() {
    }

    public Payment(Long id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
