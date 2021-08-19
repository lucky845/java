package com.book.server;

import com.book.pojo.Cart;
import com.book.pojo.Order;
import com.book.pojo.OrderItem;

import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-18 17:21
 * @project_name javaWEB
 */
public interface OrderService {

    String createOrder(Cart cart,Integer userId);//

    List<Order> queryOrders();

    int updateOrderByOrderId(String orderId,int status);

    List<OrderItem> showOrderItem(String OrderId);

    List<Order> queryOrdersById(Integer userId);

    String queryUserById(Integer id);
}
