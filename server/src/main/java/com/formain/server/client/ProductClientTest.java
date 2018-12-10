package com.formain.server.client;

import com.formain.server.dataobject.ProductInfo;
import com.formain.server.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 项目名称：order
 * 包： com.formain.order.client
 * 类名称：ProductClient.java
 * 类描述：调用product服务
 * 创建人：wufuming
 * 创建时间：2018年11月19日
 */
//@FeignClient(name = "product")
public interface ProductClientTest {

    /*@GetMapping("/product/msg")
    String productMsg();
    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIds);
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<ProductDto> productDtos);*/
}
