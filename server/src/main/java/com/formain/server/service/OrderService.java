package com.formain.server.service;

import com.formain.server.dto.OrderDto;

/**
 * 项目名称：order
 * 包： com.formain.order.service
 * 类名称：OrderService.java
 * 类描述：订单service
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
public interface OrderService {

    OrderDto create(OrderDto orderDto);
}
