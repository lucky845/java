package 多线程.练习题目;

/**
 *
 * 编写生产者消费者多线程程序，设有一个最大库存量为4的电视机仓库，
 * 生产10台电视机，一边生产一边销售（消费）。
 *
 * @author lichuang
 * @create 2021-06-23 13:12
 */
class TV {

    private int tv = 0;

    public int getTv() {
        return tv;
    }

    public synchronized void add(){
        if(tv <= 10) {
            tv++;
            notify();

            if(tv > 4){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public synchronized void del(){
        if(tv > 0) {
            tv--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class P implements Runnable{

    private TV t;

    public P(TV t) {
        this.t = t;
    }

    @Override
    public void run() {
        while (true) {


                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t.add();
                System.out.println(Thread.currentThread().getName() + t.getTv());

        }
    }
}

class S implements Runnable{

    private TV t;

    public S(TV t) {
        this.t = t;
    }

    @Override
    public void run() {
        while (true) {

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            t.del();
            System.out.println(Thread.currentThread().getName() + t.getTv());

        }
    }
}

public class ThreadTest8 {
    public static void main(String[] args) {
        TV t =new TV();

        P s = new P(t);
        S p = new S(t);

        Thread t1 = new Thread(s);
        Thread t2 = new Thread(p);

        t1.setName("生产");
        t2.setName("消费");

        t1.start();
        t2.start();

    }
}
