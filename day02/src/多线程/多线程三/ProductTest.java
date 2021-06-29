package 多线程.多线程三;

/**
 *
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1.是否是多线程问题？是，生产者线程，消费者线程
 * 2.是否有线程安全问题？是，店员（或产品）
 * 3.如何解决线程安全问题？同步机制，有三种方法
 * 4.是否涉及到线程的通信？是
 *
 * @author lichuang
 * @create 2021-06-20 22:23
 */
class Clerk{

    private int productCount = 0;

    public int getA() {
        return productCount;
    }

    public void setA(int a) {
        this.productCount = productCount;
    }

    public synchronized void productorProduct() { // 生产产品

        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + " :开始生产第" + productCount + "个产品");

            notify(); // 唤醒消费者

        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public synchronized void consumeProduct() { // 消费产品

        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productCount + "个产品");
            productCount--;

            notify(); // 唤醒生产者

        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Productor extends Thread{ // 生产者

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run(){

            System.out.println(Thread.currentThread().getName() + " : 开始生产产品····");

            while (true){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                clerk.productorProduct();

        }
    }
}

class Consumer extends Thread{ // 消费者

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run(){

            System.out.println(Thread.currentThread().getName() + " : 开始消费····");


            while (true) {

                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                clerk.consumeProduct();

        }
    }
}

public class ProductTest {
    public static void main(String[] args) {

        Clerk clerk = new Clerk();

        Productor productor1 = new Productor(clerk);
        productor1.setName("生产者1");

        Consumer consumer1 = new Consumer(clerk);
        consumer1.setName("消费者1");

        Consumer consumer2 = new Consumer(clerk);
        consumer2.setName("消费者2");

        productor1.start();
        consumer1.start();
        consumer2.start();
    }
}
