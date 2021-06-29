package 多线程.练习题目;

/**
 *
 * 模拟3个人排除买票，每人买1张票。售货员只有1张五元的钱，
 * 电影票5元一张，王大拿拿一张二十元的人民币排在谢大脚前面买票，
 * 谢大脚拿1张十元的人民币排在在赵四的前面买票，
 * 赵四拿1张五元的人民币排在最后。
 * 即最终的卖票次序是：谢大脚、赵四、王大拿
 *
 * @author lichuang
 * @create 2021-06-23 12:31
 */
class SalesMan{

    private int money = 5;
    private int price = 5;

    public void addmoney(){
        money += price;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean canBuyTicket(int money){
        if(this.money >= money - price){
            return true;
        }else{
            return false;
        }
    }
}

class buyTicket implements Runnable{

    private int money;
    private int ticket = 0;
    private SalesMan s;

    public buyTicket(int money, SalesMan s) {
        this.money = money;
        this.s = s;
    }

    @Override
    public void run() {

        while(ticket == 0){
            synchronized (s){
                if(s.canBuyTicket(money)){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    s.addmoney();
                    ticket++;
                    System.out.println(Thread.currentThread().getName() + "买到一张票");
                }
            }

        }
    }
}

public class ThreadTest7 {
    public static void main(String[] args) {
        SalesMan s = new SalesMan();

        buyTicket b1 = new buyTicket(20,s);
        buyTicket b2 = new buyTicket(10,s);
        buyTicket b3 = new buyTicket(5,s);

        Thread t1 = new Thread(b1);
        Thread t2 = new Thread(b2);
        Thread t3 = new Thread(b3);

        t1.setName("王大拿");
        t2.setName("谢大脚");
        t3.setName("赵四");

        t3.setPriority(1); // 让赵四在谢大脚后面买票
        t2.setPriority(10);

        t1.start();
        t2.start();
        t3.start();
    }
}
