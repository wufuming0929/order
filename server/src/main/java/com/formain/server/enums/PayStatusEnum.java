package com.formain.server.enums;

import lombok.Getter;

/**
 * 项目名称：order
 * 包： com.formain.order.enums
 * 类名称：PayStatusEnum.java
 * 类描述：支付状态枚举
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付完成");

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
