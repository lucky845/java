package 多线程.多线程一;

/**
 *
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 *
 * 关于同步方法的总结：
 * 1.同步方法任然涉及到同步监视器，只是不需要我们显式的声明。
 * 2.非静态的同步方法，同步监视器是：this
 *    静态的同步方法，同步监视器是：当前类本身
 *
 * @author lichuang
 * @create 2021-06-20 15:04
 */
class Window3 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {

            show();

            }
        }

        private synchronized void show(){  // 同步监视器：this
//        synchronized (this) {

            if (ticket > 0) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ": 卖票,票号为:" + ticket);
                ticket--;
            }
//        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {

        Window3 w1 = new Window3();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();

    }
}
