package 多线程.练习题目;

/**
 *
 * 实现一个由A、B、C三个窗口同时销售100张票的系统，
 * 要求打印出每个窗口打印的售票情况，并且每个窗口不得连续售票。
 *
 * @author lichuang
 * @create 2021-06-23 12:18
 */
class Window implements Runnable{

    private static int tiktck = 100;

    @Override
    public void run() {

        while(true) {

            synchronized (this) {
                if (tiktck > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " : " + tiktck);
                    tiktck--;
                }
            }
        }
    }
}

public class ThreadTest6 {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口A");
        t2.setName("窗口B");
        t3.setName("窗口C");

        t1.start();
        t2.start();
        t3.start();
    }
}
