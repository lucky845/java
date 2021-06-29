package 多线程.练习题目;

/**
 *
 * 模拟一个人生产50个玩具，每200毫秒生产一个，
 * 当生产到第20个时加入每秒吃1个馒头，共吃完3个后在接着生产的多线程。
 *
 *
 * @author lichuang
 * @create 2021-06-22 19:23
 */
class Penser implements Runnable{

    private int toy = 0;
    private int bread = 3;

    @Override
    public void run() {

        while (true){
            if(toy < 50){
                if(toy == 20){
                    while(bread > 0){
                        eat();
                    }
                }
                production();
            }else{
                Thread.yield();
            }
        }
    }

    public synchronized void production(){ // 生产玩具的方法

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        toy++;
        System.out.println(Thread.currentThread().getName() + " 正在生产玩具: " + toy);

    }

    public synchronized void eat() { // 吃馒头的方法

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " 开始吃第: " + bread + "个馒头");
        bread--;

    }
}



public class ThreadTest2 {
    public static void main(String[] args) {

        Penser p = new Penser();
        Thread t1 = new Thread(p);

        t1.setName("线程");

        t1.start();


    }
}
