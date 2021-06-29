package 多线程.多线程一;

/**
 *
 * 多线程的创建:
 * 方式一:继承与Thread
 * 1.创建一个继承与Thread的子类
 * 2.重写Thread类的run()
 * 3.创建Thread类的子类对象
 * 4.通过此对象调用start()
 * <p>
 *     例子:遍历100以内的所有偶数
 *
 * 方式二:
 *
 *
 * @author lichuang
 * @create 2021-06-19 16:53
 */
// 1.创建一个继承与Thread的子类
 class MyThread extends Thread{
    // 2.重写Thread类的run()
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }

}

public class ThreadTest{
    public static void main(String[] args) {
        // 3.创建Thread类的子类的对象
        MyThread thread1 = new MyThread();

        // 4.通过此对象调用start():①启动当前线程②调用当前线程的方法
        thread1.start();
        //问题一:我们不能通过直接调用run()的方式启动多线程
//        thread.run();

        // 问题二:再启动一个线程,遍历100内的偶数.不可以让已经start()的线程去执行会报IllegalThreadStateException异常
//        thread.start();

        //我们需要重新创建一个线程的对象
        MyThread thread2 = new MyThread();
        thread2.start();

        // 主线程:仍然在main线程中执行
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + i + "*********main*******");
            }
        }
    }


}