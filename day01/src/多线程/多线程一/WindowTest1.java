package 多线程.多线程一;

/**
 * 例子:创建三个窗口卖票,总票数为100张.使用接口Runnable的方式
 *
 * 存在线程安全问题:待解决
 *
 * @author lichuang
 * @create 2021-06-19 20:20
 */

class Window1 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while(true){

            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + ": 卖票,票号为:" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {

        Window w1 = new Window();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();

    }
}
