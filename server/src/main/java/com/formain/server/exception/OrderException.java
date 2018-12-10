package com.formain.server.exception;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * 项目名称：order
 * 包： com.formain.order.exception
 * 类名称：OrderException.java
 * 类描述：统一异常
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
public class OrderException extends RuntimeException{

    private Integer code;

    private String msg;

    public OrderException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}