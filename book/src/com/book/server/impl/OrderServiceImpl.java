package com.book.server.impl;

import com.book.dao.BookDAO;
import com.book.dao.OrderDAO;
import com.book.dao.OrderItemDAO;
import com.book.dao.UserDAO;
import com.book.dao.impl.BookDAOImpl;
import com.book.dao.impl.OrderDAOImpl;
import com.book.dao.impl.OrderItemDAOImpl;
import com.book.dao.impl.UserDAOImpl;
import com.book.pojo.*;
import com.book.server.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lichuang
 * @create 2021-08-18 17:23
 * @project_name javaWEB
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private BookDAO bookDAO = new BookDAOImpl();
    private UserDAO userDao = new UserDAOImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {

//        System.out.println("OrderServiceImpl程序在" + Thread.currentThread().getName() + "线程中");

        // 订单号===唯一性
        String orderId = System.currentTimeMillis()+""+userId;
        // 创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(), 0,userId);
        // 保存订单
        orderDAO.saveOrder(order);

        // 12 / 0;

        // 遍历购物车中每一个商品项转换成为订单项保存到数据库
        for(Map.Entry<Integer, CartItem> entry:cart.getItems().entrySet()){
            // 获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            // 转换为每一个订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            // 保存到数据库
            orderItemDAO.saveOrderItem(orderItem);

            // 更新库存和销量
            Book book = bookDAO.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDAO.updateBook(book);

        }
        // 清空购物车
        cart.clear();

        return orderId;
    }

    /**
     * 管理员查询全部订单
     * @return
     */
    @Override
    public List<Order> queryOrders() {
        return orderDAO.queryOrders();
    }

    /**
     * 发货
     * @param orderId
     * @return
     */
    @Override
    public int updateOrderByOrderId(String orderId, int status) {
        return orderDAO.updateOrderByOrderId(orderId,status);
    }

    /**
     * 管理员/用户查看订单详情
     * @param orderId 通过订单号
     * @return
     */
    @Override
    public List<OrderItem> showOrderItem(String orderId) {
        return orderItemDAO.queryOrderItemByOrderId(orderId);
    }

    /**
     * 用户查看订单详情
     * @param userId
     * @return
     */
    @Override
    public List<Order> queryOrdersById(Integer userId) {
        return orderDAO.queryOrdersById(userId);
    }

    @Override
    public String queryUserById(Integer id) {
        return userDao.queryUserById(id);
    }
}
