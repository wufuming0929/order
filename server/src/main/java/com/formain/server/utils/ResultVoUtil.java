package com.formain.server.utils;

import com.formain.server.vo.ResultVo;

/**
 * 项目名称：order
 * 包： com.formain.order.utils
 * 类名称：ResultUtil.java
 * 类描述：统一返回值工具类
 * 创建人：wufuming
 * 创建时间：2018年11月18日
 */
public class ResultVoUtil {

    public static <T>ResultVo<T> success(T data){
        ResultVo<T> resultVo = new ResultVo<T>();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(data);
        return resultVo;
    }

}