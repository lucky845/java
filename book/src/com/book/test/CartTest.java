package com.book.test;

import com.book.pojo.Cart;
import com.book.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author lichuang
 * @create 2021-08-18 13:00
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到入土",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java从入门到入土",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"java从入门",1,new BigDecimal(1000),new BigDecimal(1000)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到入土",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java从入门到入土",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"java从入门",1,new BigDecimal(1000),new BigDecimal(1000)));

        cart.deleteItem(1);

        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到入土",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java从入门到入土",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"java从入门",1,new BigDecimal(1000),new BigDecimal(1000)));

        cart.deleteItem(1);

        cart.clear();

        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到入土",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java从入门到入土",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"java从入门",1,new BigDecimal(1000),new BigDecimal(1000)));

        cart.deleteItem(1);

        cart.clear();

        cart.addItem(new CartItem(1,"java从入门到入土",1,new BigDecimal(100),new BigDecimal(100)));

        cart.updateCount(1,10);

        System.out.println(cart);
    }
}