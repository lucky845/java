package 多线程.多线程二;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author lichuang
 * @create 2021-06-20 15:25
 */
public class BankTest {
}

class Bank {

    private Bank(){}

    private static Bank instance = null;


    public static synchronized Bank getInstance() {
        //方式一：效率稍差
//        synchronized (Bank.class){
//          if (instance == null) {
//              instance = new Bank();
//          }
//        }
//
//          return instance;
//      }

        //方式二：
        if (instance == null) {

            synchronized (Bank.class) {
                if (instance == null) {

                    instance = new Bank();
                }
            }
        }

        return instance;

    }
}