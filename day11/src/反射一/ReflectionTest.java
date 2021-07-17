package 反射一;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author lichuang
 * @create 2021-07-17 15:57
 */
public class ReflectionTest {

    // 反射之前,对于Person的操作
    @Test
    public void test1(){

        // 1.创建Person类的对象
        Person p1 = new Person("Tom",12);

        // 2.通过对象,调用其内部的属性\方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        // 在Person类外部,不可以通过Person类的对象调用其内部的私有结构
        // 比如:name、showNation()以及私有的构造器

    }

    // 反射之后,对于Person的操作
    @Test
    public void test2() throws Exception {

        // 1.通过反射，创建Person类的对象
        Class aClass = Person.class;
        Constructor cons = aClass.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());
        // 2.通过反射，调用对象指定的属性、方法
        // 调用属性
        Field age = aClass.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        // 调用方法
        Method show = aClass.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("********************************");

        // 通过反射，可以调用Person类的私有结构。比如：私有的构造器、方法属性
        Constructor cons1 = aClass.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("jerry");
        System.out.println(p1.toString());

        // 调用私有的属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"HanMeiMei");
        System.out.println(p1.toString());

        // 调用私有的方法
        Method showNation = aClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"中国"); // 相当于p1.showNation("中国")
        System.out.println(nation); // 中国

    }

    // 疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用哪一个？
    // 建议：直接new方式。
    // 什么时候会使用：反射的方式。 反射的特征：动态性。
    // 疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
    // 不矛盾。

    /*
    关于java.lang.Class类的理解
    1. 类的加载过程：
    程序在经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
    接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某一个字节码文件加载到内存中。此过程
    就称为类的加载。加载到内存中的类，我们就称为运行时类，此运行时类，就作为Class类的一个实例。

    2. 换句话说,Class的实例就对应着一个运行时类.
    3. 加载到内存中的运行时类,会缓存一段时间.在此时间之内,我们可以通过不同的方式
    来获取此运行时类.

     */
    // 获取Class实例的方式 (前三种方式需要掌握)
    @Test
    public void test3() throws ClassNotFoundException {
        // 方式一:调用运行时类的属性: .class
        Class<Person> class1 = Person.class;
        System.out.println(class1);

        // 方式二:通过运行时类的对象
        Person p1 = new Person();
        Class<? extends Person> class2 = p1.getClass();
        System.out.println(class2);

        // 方式三:调用Class的静态方法:forName(String classPath)
        Class<?> class3 = Class.forName("反射一.Person");
//        class3 = Class.forName("java.lang.String");
        System.out.println(class3);

        System.out.println(class1 == class2);
        System.out.println(class1 == class3);

        // 方式四:使用类的加载器:ClassLoader(了解)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> class4 = classLoader.loadClass("反射一.Person");
        System.out.println(class4);

    }

    // 万事万物皆对象？对象.Xxx,File,URL,反射,前端,数据库


    // Class实例可以是那些结构的说明
    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }

}
