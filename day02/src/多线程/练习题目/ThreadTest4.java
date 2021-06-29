package 多线程.练习题目;

/**
 *
 * 改进上题的龟兔赛跑程序，通过改变优先级，并减掉休眠时间，使得乌龟以迅雷不及掩耳的速度跑完100米。
 *
 * @author lichuang
 * @create 2021-06-22 22:04
 */
class rabbit1 implements Runnable{

    private static int length = 100;


    @Override
    public synchronized void run() {
        while (length > 0){
            length -= 10;

            if(length % 10 == 0){
                System.out.println("兔子现在还剩下" + length + "米");
            }
        }
    }
}

class tortoise1 implements Runnable{

    private int length = 100;

    @Override
    public synchronized void run() {
        while (length > 0){
            length -= 4;

            if(length % 10 == 0){
                System.out.println("乌龟现在还剩下" + length + "米");
            }
        }
    }
}

public class ThreadTest4 {
    public static void main(String[] args) {

        rabbit1 r = new rabbit1();
        tortoise1 t = new tortoise1();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(t);

        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();
    }
}
