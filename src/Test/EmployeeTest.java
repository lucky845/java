package Test;
/*
编写一个Employee类，声明为抽象类，
包含如下三个属性：name，id，salary。
提供必要的构造器和抽象方法：work()。


 */
public class EmployeeTest {
    public static void main(String[] args) {

        Employee m = new Manager("小明",10010,5000,10000);

        m.work();

        CommonEmployee c  =new CommonEmployee();
        c.work();
    }
}

abstract class Employee{
    private String name;
    private int id;
    private double salary;

    public Employee(){

    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract void work();
}
/*
对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。
请使用继承的思想，设计CommonEmployee类和Manager类，要求类
中提供必要的方法进行属性访问。
 */
class Manager extends Employee{
    private double bonus; // 奖金

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
        public void work() {
            System.out.println("管理员工");
        }

}

class CommonEmployee extends Employee{


    @Override
    public void work() {
        System.out.println("工作");
    }
}