package com.tomshidi.springcloud.enums;

/**
 * @Author TomShiDi
 * @Since 2020/7/17
 * @Version 1.0
 */
public enum OrderEnum {
    /**
     *
     */
    ORDER_CREATING(0,"订单创建中"),
    ORDER_CREATED(1, "订单创建完毕"),
    ;


    private Integer code;

    private String message;

    OrderEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
