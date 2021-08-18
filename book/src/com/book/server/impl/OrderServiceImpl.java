package com.book.server.impl;

import com.book.dao.BookDAO;
import com.book.dao.OrderDAO;
import com.book.dao.OrderItemDAO;
import com.book.dao.impl.BookDAOImpl;
import com.book.dao.impl.OrderDAOImpl;
import com.book.dao.impl.OrderItemDAOImpl;
import com.book.pojo.*;
import com.book.server.OrderService;

import java.util.Date;
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

    @Override
    public String createOrder(Cart cart, Integer userId) {
        // 订单号===唯一性
        String orderId = System.currentTimeMillis()+""+userId;
        // 创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(), 0,userId);
        // 保存订单
        orderDAO.saveOrder(order);

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
}
