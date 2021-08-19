package com.book.dao.impl;

import com.book.dao.BaseDAO;
import com.book.dao.OrderItemDAO;
import com.book.pojo.OrderItem;

import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-18 16:13
 * @project_name javaWEB
 */
public class OrderItemDAOImpl extends BaseDAO implements OrderItemDAO {

    /**
     * 生成订单项
     * @param orderItem
     * @return
     */
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`, `total_price`,`order_id`)values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),
                orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    /**
     * 根据订单号查询订单明细
     * @param orderId
     * @return
     */
    @Override
    public List<OrderItem> queryOrderItemByOrderId(String orderId) {
        String sql = "select id, name, count, price, total_price totalPrice, order_id orderId from t_order_item where order_id = ?";
        return queryForList(OrderItem.class,sql,orderId);
    }
}

