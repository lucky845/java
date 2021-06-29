package 继承super.继承super练习一;

public class Account {
    private int id; // 账户
    private double balance; // 余额
    private double annuallnterestRate; // 年利率

    public Account(int id, double balance, double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    // 获取月利率的方法
    public double getMonthlyInterest() {
        return getAnnuallnterestRate();
    }

    // 取钱的方法
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("余额不足");
        }
    }

    // 存钱的方法
    public void deposit(double amount) {
        balance += amount;
    }

}