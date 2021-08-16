package com.book.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author lichuang
 * @create 2021-08-16 16:39
 */
public class WebUtils {

    /**
     * 把Map中的值注入到对应的JavaBean属性中。
     * @Author lichuang
     * @Date 2021/8/16 17:28
     * @param value
     * @param bean
     * @return void
     */
    public static <T>  T copyParamToBean(Map value, T bean){

        try {
            /**
             * 把请求的参数注入bean中
             */
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换为int类型的数据
     * @Author lichuang
     * @Date 2021/8/16 20:39
     * @param strInt
     * @param defaultValue
     * @return int
     */
    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

}
