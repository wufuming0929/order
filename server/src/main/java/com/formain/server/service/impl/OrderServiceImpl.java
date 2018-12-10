package com.formain.server.service.impl;

import com.formain.common.DecreaseStockInput;
import com.formain.common.ProductInfoOutput;
import com.formain.product.client.ProductClient;
import com.formain.server.dataobject.OrderDetail;
import com.formain.server.dataobject.OrderMaster;
import com.formain.server.dataobject.ProductInfo;
import com.formain.server.dto.ProductDto;
import com.formain.server.enums.PayStatusEnum;
import com.formain.server.service.OrderService;
import com.formain.server.utils.OrderIdUtil;
import com.formain.server.dto.OrderDto;
import com.formain.server.enums.OrderStatusEnum;
import com.formain.server.repository.OrderDetailRepository;
import com.formain.server.repository.OrderMasterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目名称：order
 * 包： com.formain.order.service.impl
 * 类名称：OrderServiceImpl.java
 * 类描述：
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDto create(OrderDto orderDto) {
        String orderId = OrderIdUtil.uniqueOrderId();
        //查询商品信息
        List<String> productIdList = orderDto.getOrderDtailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfoOutput> productInfoOutputs = productClient.listForOrder(productIdList);

        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        List<OrderDetail> orderDtailList = orderDto.getOrderDtailList();
        for (OrderDetail orderDetail : orderDtailList) {
            for (ProductInfoOutput productInfo : productInfoOutputs) {
                if (orderDetail.getProductId().equals(productInfo.getProductId())) {
                    orderAmout = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(OrderIdUtil.uniqueOrderId());
                }
            }
        }
        orderDetailRepository.saveAll(orderDtailList);

        //扣库存
        List<DecreaseStockInput> productDtos = orderDto.getOrderDtailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(productDtos);
        //订单和订单详情入库
        OrderMaster orderMaster = new OrderMaster();
        orderDto.setOrderId(orderId);
        BeanUtils.copyProperties(orderDto,orderMaster);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderAmount(orderAmout);
        orderMasterRepository.save(orderMaster);
        return orderDto;
    }
}