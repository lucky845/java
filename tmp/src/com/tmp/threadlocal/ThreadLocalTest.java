package com.tmp.threadlocal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 * @author lichuang
 * @create 2021-08-19 18:55
 * @project_name javaWEB
 */
public class ThreadLocalTest {

    public final static Map<String,Object> data = new Hashtable<String,Object>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
    public static ThreadLocal<Object> threadLocal2 = new ThreadLocal<Object>();
    private static final Random random = new Random();

    public static class Task implements Runnable{

        @Override
        public void run() {

            threadLocal.set("abc");
            threadLocal.set("def");
            threadLocal2.set("abc");

            System.out.println(threadLocal.get());
            System.out.println(threadLocal2.get());

            /*
            // 在run方法中,随机生成一个变量（线程要关联的数据），然后以当前线程名为key保存到Map中
            int i = random.nextInt(1000);// 0-999的随机数
            String name = Thread.currentThread().getName(); // 获取当前线程名
            System.out.println("线程[" + name + "]生产的随机数是" + i);
            data.put(name,i);

            threadLocal.set(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new OrderService().createOrder();

            // 在run方法结束之前，以当前线程名获取数据并打印
//            Object o = data.get(name);
            Object o = threadLocal.get();
            System.out.println("在线程[" + name + "]快结束取出的数据是" + o);

             */
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }

}
