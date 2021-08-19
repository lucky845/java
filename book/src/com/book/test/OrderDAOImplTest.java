package com.book.test;

import com.book.dao.OrderDAO;
import com.book.dao.impl.OrderDAOImpl;
import com.book.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lichuang
 * @create 2021-08-18 16:26
 * @project_name javaWEB
 */
public class OrderDAOImplTest {

    OrderDAO orderDao = new OrderDAOImpl();

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("1234567890", new Date(),new BigDecimal(100),0, 1));
    }

    @Test
    public void queryOrders() {
        System.out.println(orderDao.queryOrders());
    }
}