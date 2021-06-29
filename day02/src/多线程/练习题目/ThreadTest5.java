package 多线程.练习题目;

/**
 * 启动两个线程对一个数字i操作
 * 1)其中1个线程每次对i加1
 * 2)另1个线程每次对i减1
 * 各运行20次，结果i的值等于初始值。
 *
 * @author lichuang
 * @create 2021-06-22 22:11
 */
class Number{

    private int i;

    public Number(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void add(){
        i++;
    }

    public void sub(){
        i--;
    }
}

class sum implements Runnable{

    private Number num;

    public sum(Number num) {
        this.num = num;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            synchronized (num) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num.add();
                System.out.println(Thread.currentThread().getName() +
                        "，i = " + num.getI());

            }
        }
    }
}

class sub implements Runnable{

    private Number num;

    public sub(Number num) {
        this.num = num;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            synchronized (num){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num.sub();
                System.out.println(Thread.currentThread().getName() +
                        "，i = " + num.getI());

            }
        }
    }
}



public class ThreadTest5 {
    public static void main(String[] args) {
        Number num = new Number(0);

        sum sum = new sum(num);
        sub sub = new sub(num);

        Thread t1 = new Thread(sum);
        Thread t2 = new Thread(sub);

        t1.setName("add");
        t2.setName("sub");

        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("i = " + num.getI());
    }
}
