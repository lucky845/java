package com.spring5.test;

import com.spring5.aopanno.User;
import com.spring5.aopxml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lichuang
 * @create 2021-08-25 15:37
 * @project_name spring5
 */
public class TestAop {

    @Test
    public void testAopAnno(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void testAopXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }
}
