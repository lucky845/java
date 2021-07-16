package IO流;

import java.io.Serializable;

/**
 * Person类需要满足如下的要求方可序列化
 * 1.需要实现接口：Serializable
 * 2.当前类需要提供一个全局常量serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性
 *   也必须是可序列化的.(默认情况下，基本数据类型可序列化)
 *
 *
 * 补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修
 *      饰的成员变量
 *
 * @author lichuang
 * @create 2021-07-15 20:49
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 121551653L;

    private String name;
    private int age;
    private int id;
    private Account acct;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int id, Account acct) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.acct = acct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", acct=" + acct +
                '}';
    }
}

class Account implements Serializable{

    public static final long serialVersionUID = 1416511523L;

    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
