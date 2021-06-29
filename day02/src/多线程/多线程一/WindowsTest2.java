package 多线程.多线程一;

import java.awt.*;

/**
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 * 例子:创建三个窗口卖票,总票数为100张.使用继承Thread类的方式
 *
 *说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 *
 * @author lichuang
 * @create 2021-06-19 19:46
 */
class Window2 extends Thread{

    private static int ticket = 100;
//    private static Object object = new Object();

    @Override
    public void run(){

        while(true){
            // synchronized(object)
//            synchronized (object){
            synchronized (Window.class){ // Class class = Window.Class只会加载一次
                // 错误的方式：this代表t1，t2，t3
//            synchronized (this){
                if(ticket > 0){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ": 卖票,票号为:" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}

public class WindowsTest2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();

    }
}
