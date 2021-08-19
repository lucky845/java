package com.book.dao.impl;

import com.book.dao.BaseDAO;
import com.book.dao.OrderDAO;
import com.book.pojo.Order;

import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-18 16:11
 * @project_name javaWEB
 */
public class OrderDAOImpl extends BaseDAO implements OrderDAO {

    /**
     * 生成订单
     * @param order
     * @return int
     */
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`)values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    /**
     * 管理员查询全部订单
     * @return List<Order>
     */
    @Override
    public List<Order> queryOrders() {
        String sql = "select order_id orderId,create_time createTime,price,status,user_id userId from t_order order by createTime desc";
        return queryForList(Order.class, sql);
    }

    /**
     * 修改订单状态
     * @param orderId 通过订单号
     * @param status
     * @return int
     */
    @Override
    public int updateOrderByOrderId(String orderId,int status) {
        String sql = "update t_order set status = ? where order_id = ? ";
        return update(sql,status,orderId);
    }

    /**
     * 用户查看订单详情
     * @param id
     * @return List<Order>
     */
    @Override
    public List<Order> queryOrdersById(Integer id) {
        String sql = "select order_id orderId,create_time createTime,price,status,user_id userId from t_order where user_id=? order by createTime desc";
        return queryForList(Order.class, sql,id);
    }
}
