package com.formain.server.dto;

import com.formain.server.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 项目名称：order
 * 包： com.formain.order.dto
 * 类名称：OrderDto.java
 * 类描述：订单数据传输对象
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
@Data
public class OrderDto {

    /** 订单id. */
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

    private List<OrderDetail> orderDtailList;

}