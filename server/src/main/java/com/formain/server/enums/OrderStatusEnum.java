package com.formain.server.enums;

import lombok.Getter;

/**
 * 项目名称：order
 * 包： com.formain.order.enums
 * 类名称：OrderStatusEnum.java
 * 类描述：订单状态枚举
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新下单"),
    FINISHED(1,"完结"),
    CANCELL(2,"取消");

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}