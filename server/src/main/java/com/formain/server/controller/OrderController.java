package com.formain.server.controller;

import com.formain.server.dataobject.OrderDetail;
import com.formain.server.dto.OrderDto;
import com.formain.server.dto.ProductDto;
import com.formain.server.exception.OrderException;
import com.formain.server.service.OrderService;
import com.formain.server.utils.ResultVoUtil;
import com.formain.server.vo.CreateOrderInvo;
import com.formain.server.vo.ResultVo;
import com.formain.server.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称：order
 * 包： com.formain.order.controller
 * 类名称：OrderController.java
 * 类描述：订单控制器
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVo<Map<String,String>> create(@Valid @RequestBody CreateOrderInvo createOrderInvo,
                                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, createOrderInvo={}", createOrderInvo);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(createOrderInvo.getName());
        orderDto.setBuyerPhone(createOrderInvo.getPhone());
        orderDto.setBuyerAddress(createOrderInvo.getAddress());
        orderDto.setBuyerOpenid(createOrderInvo.getOpenId());

        List<ProductDto> items = createOrderInvo.getItems();
        List<OrderDetail> orderDetailList = new ArrayList<>();

        for (ProductDto item : items) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductId(item.getProductId());
            orderDetail.setProductQuantity(item.getProductQuantity());
            orderDetailList.add(orderDetail);
        }
        orderDto.setOrderDtailList(orderDetailList);

        OrderDto result = orderService.create(orderDto);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVoUtil.success(map);


    }


}