package 多线程.多线程一;

/**
 * 测试Thread中的常用方法:
 * 1.start():启动当前线程,调用当前线程的run().
 * 2.run():通常需要重写Thread类中的此方法,将创建的线程要执行的操作声明在此方法中.
 * 3.currentThread():静态方法:返回执行当前代码的线程.
 * 4.getName():获取当前线程的名字.
 * 5.setName():设置当前线程的名字.
 * 6.yield():释放当前cpu的执行权.
 * 7.join():在线程A中调用线程B的join()方法,此时线程A进入阻塞状态,直到线程B完全执行完后,线程A才结束阻塞状态.
 * 8.stop():已过时.当执行此方法时,强行结束当前线程.
 * 9.sleep(long millitime):让当前进程"睡眠"指定的millitime毫秒.在指定的millitime里线程是阻塞状态.
 * 10.isAlive():判断当前线程是否存活.
 *
 *线程的优先级
 * 1.
 * MAX_PRIORITY：10
 * MIN _PRIORITY：1
 * NORM_PRIORITY：5
 *
 * 2.如何获取和设置当前线程的优先级:
 * getPriority() ：返回线程优先值
 * setPriority(int newPriority) ：改变线程的优先级
 *
 * 说明:高优先级的线程要抢占优先级低的线程的cpu执行权,但是只是从概率的角度,并不是先运行完高优先级的线程再运行低优先级的线程
 *
 * @author lichuang
 * @create 2021-06-19 18:43
 */
class HelloThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){

                // sleep()方法
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() + i + ":" + Thread.currentThread().getPriority());
            }

//            if(i % 20 == 0 ){
//               this.yield();
//            }

        }
    }

    // 使用构造器重命名线程名
    public HelloThread(String name){
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {

        HelloThread h1 = new HelloThread("线程一");

//        h1.setName("线程一");

        // 设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);

        h1.start();

        // 给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        for (int i = 0 ; i< 100 ; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + i + ":" + Thread.currentThread().getPriority());
            }

//            // join()方法
//            if(i == 20){
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        // isAlive()方法
        System.out.println(h1.isAlive());
    }
}
