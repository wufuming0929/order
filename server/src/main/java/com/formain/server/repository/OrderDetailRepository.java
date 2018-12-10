package com.formain.server.repository;

import com.formain.server.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 项目名称：order
 * 包： com.formain.order.repository
 * 类名称：OrderDetailRepository.java
 * 类描述：订单详情repository
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

}
