package com.book.dao;

import com.book.pojo.Order;

import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-18 16:10
 * @project_name javaWEB
 */
public interface OrderDAO {

    public int saveOrder(Order order);

    public List<Order> queryOrdersById(Integer id);

    public List<Order> queryOrders();

    public int updateOrderByOrderId(String orderId,int status);

}