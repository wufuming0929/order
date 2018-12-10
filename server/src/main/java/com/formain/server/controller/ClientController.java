package com.formain.server.controller;

import com.formain.common.DecreaseStockInput;
import com.formain.common.ProductInfoOutput;
import com.formain.product.client.ProductClient;
import com.formain.server.dataobject.ProductInfo;
import com.formain.server.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * 项目名称：order
 * 包： com.formain.order.controller
 * 类名称：ClientController.java
 * 类描述：客户端调用服务端测试代码
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalanced;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/client")
    public String msg(){
        //调用product的服务有如下几种方法
        //1.RestTemplate
        //RestTemplate template = new RestTemplate();
        //String response = template.getForObject("http://localhost:8081/product/msg", String.class);
        //2.利用LoadBalance
       /* ServiceInstance instance = loadBalanced.choose("PRODUCT");
        RestTemplate template = new RestTemplate();
        String url = String.format("http://%s:%s/product/msg", instance.getHost(), instance.getPort());
        String response = template.getForObject(url, String.class);*/
        //3.利用LoadBalance注解的方式
       // String response = restTemplate.getForObject("http://PRODUCT/product/msg", String.class);
        //4.利用feign
        //1)首先引入openfeign的依赖包
        //2)在启动类上添加@EnableFeignClients注解
        //3)新建一个接口添加@FeignClient注解
        //String response = productClient.productMsg();
        //log.info("url:{}",url);
        //log.info("response---->{}",);
        return "response";
    }
    @GetMapping("/getOrderList")
    public String getOrderList(){
        List<ProductInfoOutput> productInfoOutputs = productClient.listForOrder(Arrays.asList("164103465734242707"));
        log.info("response="+productInfoOutputs);
        return "ok";
    }
    @GetMapping("/decreaseStock")
    public String decreaseStock(){
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput("157875196366160022",2);
        productClient.decreaseStock(Arrays.asList(decreaseStockInput));
        return "ok";
    }
}