package com.formain.server.repository;

import com.formain.server.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 项目名称：order
 * 包： com.formain.order.repository
 * 类名称：OrderMasterRepository.java
 * 类描述：订单repository
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

}
