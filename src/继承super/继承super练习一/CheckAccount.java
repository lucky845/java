package 继承super.继承super练习一;

public class CheckAccount extends Account {
    private double overdraft;


    public double getOverdraft() {
        return overdraft;
    }


    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }


    public CheckAccount(int id, double balance, double annuallnterestRate, double overdraft) {
        super(id, balance, annuallnterestRate);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) { // 余额足够直接扣款
            setBalance(getBalance() - amount);
            // super.witdraw(amount);
        } else if (overdraft >= amount - getBalance()) { // ͸֧余额不足余额加透支额度
            overdraft -= (amount - getBalance());
            setBalance(0);
            // super.withdraw(getBalance);
        } else {
            System.out.println("账户余额不足!");
        }
    }


}
