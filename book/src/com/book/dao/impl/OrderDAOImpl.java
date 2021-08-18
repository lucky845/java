package com.book.dao.impl;

import com.book.dao.BaseDAO;
import com.book.dao.OrderDAO;
import com.book.pojo.Order;

/**
 * @author lichuang
 * @create 2021-08-18 16:11
 * @project_name javaWEB
 */
public class OrderDAOImpl extends BaseDAO implements OrderDAO {

    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`)values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
