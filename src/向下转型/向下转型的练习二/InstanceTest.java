package 向下转型.向下转型的练习二;

/*
        建立InstanceTest 类，在类中定义方法
        method(Person e);
        在method中:
        (1)根据e的类型调用相应类的getInfo()方法。
        (2)根据e的类型执行：
        如果e为Person类的对象，输出：
        “多线程.练习题目.ThreadTest person”;
        如果e为Student类的对象，输出：
        “多线程.练习题目.ThreadTest student”
        “多线程.练习题目.ThreadTest person ”
        如果e为Graduate类的对象，输出：
        “多线程.练习题目.ThreadTest graduated student”
        “多线程.练习题目.ThreadTest student”
        “多线程.练习题目.ThreadTest person”
 */
public class InstanceTest {
    public static void main(String[] args) {
        InstanceTest i = new InstanceTest();
        i.method(new Student());
    }

    public void method(Person e) {

        String info = e.getInfo();
        System.out.println(info);
        // 方式一:
//       if(e instanceof Graduate){
//           System.out.println("多线程.练习题目.ThreadTest graduated student");
//           System.out.println("多线程.练习题目.ThreadTest student");
//           System.out.println("多线程.练习题目.ThreadTest person");
//       }else if(e instanceof Student){
//           System.out.println("多线程.练习题目.ThreadTest student");
//           System.out.println("多线程.练习题目.ThreadTest person");
//       }else{
//           System.out.println("'多线程.练习题目.ThreadTest person");
//       }
        // 方式二:
        if (e instanceof Graduate) {
            System.out.println("多线程.练习题目.ThreadTest graduated student");
        }
        if (e instanceof Student) {
            System.out.println("多线程.练习题目.ThreadTest student");
        }
        if (e instanceof Person) {
            System.out.println("多线程.练习题目.ThreadTest person");
        }
    }
}

class Person {

    protected String name = "person";
    protected int age = 50;

    public String getInfo() {
        return "Name: " + name + "\n" + "age: " + age;
    }
}

class Student extends Person {
    protected String school = "pku";

    public String getInfo() {
        return "Name: " + name + "\nage: " + age
                + "\nschool: " + school;
    }
}

class Graduate extends Student {
    public String major = "IT";

    public String getInfo() {
        return "Name: " + name + "\nage: " + age
                + "\nschool: " + school + "\nmajor:" + major;
    }
}
