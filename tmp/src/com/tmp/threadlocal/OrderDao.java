package com.tmp.threadlocal;

/**
 * @author lichuang
 * @create 2021-08-19 19:13
 * @project_name javaWEB
 */
public class OrderDao {

    public void saveOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("OrderDao 当前线程["+ name +"]中保存的数据是" + ThreadLocalTest.threadLocal.get());
    }

}
