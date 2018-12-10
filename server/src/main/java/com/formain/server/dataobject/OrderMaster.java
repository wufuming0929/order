package com.formain.server.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 项目名称：order
 * 包： com.formain.order.dataobject
 * 类名称：OrderMaster.java
 * 类描述：订单实体类
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
@Data
@Entity
public class OrderMaster {

    /** 订单id. */
    @Id
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    /** 创建时间. */
    //private Date createTime;

    /** 更新时间. */
    //private Date updateTime;

}