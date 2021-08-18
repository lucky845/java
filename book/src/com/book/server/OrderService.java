package com.book.server;

import com.book.pojo.Cart;

/**
 * @author lichuang
 * @create 2021-08-18 17:21
 * @project_name javaWEB
 */
public interface OrderService {

    public String createOrder(Cart cart,Integer userId);

}
