package com.formain.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 项目名称：product
 * 包： com.formain.dto
 * 类名称：ProdcutDto.java
 * 类描述：产品数据传输对象
 * 创建人：wufuming
 * 创建时间：2018年11月21日
 */
@Data
@NoArgsConstructor
public class ProductDto {
    @NotEmpty(message = "购物车产品id不能为空")
    private String productId;
    @NotNull(message = "购物车产品数量不能为空")
    private Integer productQuantity;

    public ProductDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}