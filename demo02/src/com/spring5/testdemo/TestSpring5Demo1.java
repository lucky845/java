package com.spring5.testdemo;

import com.spring5.autowire.Emp;
import com.spring5.bean.Orders;
import com.spring5.collectiontype.Book;
import com.spring5.collectiontype.Course;
import com.spring5.collectiontype.Stu;
import com.spring5.factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lichuang
 * @create 2021-08-22 19:12
 * @project_name spring5
 */
public class TestSpring5Demo1 {

    @Test
    public void testCollection1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = context.getBean("stu", Stu.class);
        stu.test();
    }

    @Test
    public void testCollection2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book1 = context.getBean("book", Book.class);

        Book book2 = context.getBean("book", Book.class);
//        book.test();
        System.out.println(book1);
        System.out.println(book2);
    }

    @Test
    public void testCollection3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }

    @Test
    public void testbean3() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步 获取创建bean对象方法");
        System.out.println(orders);

        // 手动让bean实例销毁
        context.close();
    }

    @Test
    public void test5() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);

    }
}
