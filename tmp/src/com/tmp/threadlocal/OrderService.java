package com.tmp.threadlocal;

/**
 * @author lichuang
 * @create 2021-08-19 19:08
 * @project_name javaWEB
 */
public class OrderService {

    public void createOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("OrderService 当前线程["+ name +"]中保存的数据是" + ThreadLocalTest.threadLocal.get());
        new OrderDao().saveOrder();
    }

}
