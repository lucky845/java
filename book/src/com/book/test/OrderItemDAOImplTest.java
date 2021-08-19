package com.book.test;

import com.book.dao.OrderItemDAO;
import com.book.dao.impl.OrderItemDAOImpl;
import com.book.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author lichuang
 * @create 2021-08-18 17:15
 * @project_name javaWEB
 */
public class OrderItemDAOImplTest {

    OrderItemDAO orderItemDao = new OrderItemDAOImpl();

    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null,"java 从入门到精通", 1,new BigDecimal(100),new
                BigDecimal(100),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"javaScript 从入门到精通", 2,new
                BigDecimal(100),new BigDecimal(200),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"Netty 入门", 1,new BigDecimal(100),new
                BigDecimal(100),"1234567890"));
    }

    @Test
    public void queryOrderItemByOrderId() {
        System.out.println(orderItemDao.queryOrderItemByOrderId("1234567890"));
    }
}