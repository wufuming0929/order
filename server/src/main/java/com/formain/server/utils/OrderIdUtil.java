package com.formain.server.utils;

import java.util.Random;

/**
 * 项目名称：order
 * 包： com.formain.order.utils
 * 类名称：OrderIdUtil.java
 * 类描述：简单实现生成唯一订单号工具类
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
public class OrderIdUtil {
    /**
     * 订单号唯一生成方法,简单实现:时间戳+随机数(6位数)
     * @return 订单号id
     */
    public static synchronized String uniqueOrderId(){
        Random random = new Random();
        int rand=random.nextInt(900000)+100000;
        long timeMillis = System.currentTimeMillis();
        return timeMillis+String.valueOf(rand);
    }
}