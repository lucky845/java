package 多线程.练习一;

/**
 *
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
 * 印账户余额。
 *
 * 1，明确哪些代码是多线程运行代码，须写入run()方法
 * 2，明确什么是共享数据。
 * 3，明确多线程运行代码中哪些语句是操作共享数据的。
 *
 * @author lichuang
 * @create 2021-06-20 18:19
 */
class Account{

    private double balance;

    public Account(double balance){
        this.balance = balance;
    }

    // 存钱的方法
    public synchronized void deposit(double amt){ // 同步监视器：this
        if(amt > 0) {
            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "存钱成功，余额为： " + balance);
        }
    }
}

class Customer extends Thread{

    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {

                for (int i = 0; i < 3; i++) {

                    acct.deposit(1000);


        }

    }
}


public class BankTest {
    public static void main(String[] args) {

        Account acct = new Account(0);

        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("客户一");
        c2.setName("客户二");

        c1.start();
        c2.start();
    }
}
