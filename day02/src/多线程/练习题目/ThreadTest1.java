package 多线程.练习题目;

/**
 *
 * 定义两个线程（一个用继承Thread类，一个用实现Runnable接口），定义一个测试类包括一个主函数调用两个子线程（具体实现自定）
 *
 *
 * @author lichuang
 * @create 2021-06-22 18:51
 */
class Thread1 extends Thread {

    @Override
    public synchronized void run(){

        for (int i = 0; i < 100; i++) {

            if(i % 2 ==0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }

}

class Thread2 implements Runnable{


    @Override
    public synchronized void run() {

        for (int i = 0; i < 100; i++) {

            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}

public class ThreadTest1{

    public static void main(String[] args){

        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2(); // 实现的方式,需要创建Thread的对象

        Thread t3 = new Thread(t2);

        t1.start();
        t3.start();

    }
}

