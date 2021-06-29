package 抽象类练习.练习一;
/*
（1）定义一个Employee类，该类包含：
private成员变量name,number,birthday，其中birthday 为MyDate类的对象；
abstract方法earnings()；
toString()方法输出对象的name,number和birthday。
 */

public abstract class Employee {

    private String name; // 姓名
    private int number; // 编号
    private MyDate birthday; // MyDate 的对象

    public abstract double earnings(); // 收益

    public Employee() {
    }

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday.toDateString();
    }
}

