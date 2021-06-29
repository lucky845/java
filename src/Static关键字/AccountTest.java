package Static关键字;
/*
编写一个类实现银行账户的概念，包含的属性有“帐号”、“密
码”、“存款余额”、“利率”、“最小余额”，定义封装这些
属性的方法。账号要自动生成。
编写主类，使用银行账户类，输入、输出3个储户的上述信息。
考虑：哪些属性可以设计成static属性。

 */
class Account {

    private int id; // ID
    private String password = "000000"; // 密码
    private double balance; // 余额
    private static double interestRate; // 利率
    private static double minMoney = 1.0; // 最小余额
    private static int init = 1001; // 初始ID
    private static int total; // 记录客户个数


    public Account() {
        id = init++;
        total++;
    }

    public Account(String password, double balance) {
        this();

        this.password = password;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public static double getMinMoney() {
        return minMoney;
    }

    public static void setMinMoney(double minMoney) {
        Account.minMoney = minMoney;
    }

    public static int getInit() {
        return init;
    }


    public static int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", balance=" + balance + "interestRate = " +
                interestRate + '}';
    }
}

public class AccountTest{

    public static void main(String[] args) {
        Account a1 = new Account("123456",1000);
        Account a2 = new Account("123456",1000);
        Account a3 = new Account("123456",1000);

        Account.setInterestRate(0.0045);
        Account.setMinMoney(10);


        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());


    }

}