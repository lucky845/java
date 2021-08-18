package com.book.dao.impl;

import com.book.dao.BaseDAO;
import com.book.dao.OrderItemDAO;
import com.book.pojo.OrderItem;

/**
 * @author lichuang
 * @create 2021-08-18 16:13
 * @project_name javaWEB
 */
public class OrderItemDAOImpl extends BaseDAO implements OrderItemDAO {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`)values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),
                orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}

