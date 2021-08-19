package com.book.dao;

import com.book.pojo.OrderItem;

import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-18 16:12
 * @project_name javaWEB
 */
public interface OrderItemDAO {

    public int saveOrderItem(OrderItem orderItem);

    public List<OrderItem> queryOrderItemByOrderId(String orderId);

}
