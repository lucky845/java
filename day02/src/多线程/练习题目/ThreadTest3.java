package 多线程.练习题目;

/**
 *
 * 编写龟兔赛跑多线程程序，设赛跑长度为100米，每跑完10米输出一次结果。
 *
 * @author lichuang
 * @create 2021-06-22 21:08
 */
class rabbit implements Runnable{

    private static int length = 100;


    @Override
    public synchronized void run() {
        while (length > 0){
            length -= 2;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(length % 10 == 0){
                System.out.println("兔子现在还剩下" + length + "米");
            }
        }
    }
}

class tortoise implements Runnable{

    private int length = 100;

    @Override
    public synchronized void run() {
        while (length > 0){
            length--;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(length % 10 == 0){
                System.out.println("乌龟现在还剩下" + length + "米");
            }
        }
    }
}

public class ThreadTest3 {
    public static void main(String[] args) {

        rabbit r = new rabbit();
        tortoise t = new tortoise();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(t);

        t1.start();
        t2.start();
    }
}
