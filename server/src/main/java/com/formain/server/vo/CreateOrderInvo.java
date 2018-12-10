package com.formain.server.vo;

import com.formain.server.dto.ProductDto;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 项目名称：order
 * 包： com.formain.order.vo
 * 类名称：CreateOrderInvo.java
 * 类描述：新订单入参
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
@Data
public class CreateOrderInvo {

    @NotEmpty(message = "名字不能为空")
    private String name;
    @NotEmpty(message = "电话不能为空")
    private String phone;
    @NotEmpty(message = "地址不能为空")
    private String address;
    @NotEmpty(message = "openId不能为空")
    private String openId;
    @Valid
    @NotEmpty(message = "购物车不能为空")
    private List<ProductDto> items;

}