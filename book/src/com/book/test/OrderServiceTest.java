package com.book.test;

import com.book.pojo.Cart;
import com.book.pojo.CartItem;
import com.book.server.OrderService;
import com.book.server.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author lichuang
 * @create 2021-08-18 17:34
 * @project_name javaWEB
 */
public class OrderServiceTest {

    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100), new BigDecimal(100)));

        System.out.println("订单号是：" + orderService.createOrder(cart, 1));
    }

    @Test
    public void queryOrders() {
        System.out.println(orderService.queryOrders());
    }

    @Test
    public void updateOrderByOrderId() {
        System.out.println(orderService.updateOrderByOrderId("1234567890",0));
    }

    @Test
    public void showOrderItem() {
        System.out.println(orderService.showOrderItem("1234567890"));
    }
}