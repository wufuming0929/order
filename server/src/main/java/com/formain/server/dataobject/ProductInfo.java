package com.formain.server.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 项目名称：product
 * 包： com.formain.product.dataobject
 * 类名称：ProductInfo.java
 * 类描述：商品信息实体类
 * 创建人：wufuming
 * 创建时间：2018年11月17日
 */
@Data
@Entity
//@Table(name = "ng_xxx_xxx")表名不一致
public class ProductInfo {

    @Id//主键
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

}