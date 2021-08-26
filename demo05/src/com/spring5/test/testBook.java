package com.spring5.test;

import com.spring5.entity.Book;
import com.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-25 18:07
 * @project_name spring5
 */
public class testBook {

    ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
    BookService bookService = context.getBean("bookService", BookService.class);

    @Test
    public void testJdbcTemplate1(){
        bookService.addBook(new Book("1","java","A"));
    }

    @Test
    public void testJdbcTemplate2(){
        bookService.updateBook(new Book("1","javascript","B"));
    }

    @Test
    public void testJdbcTemplate3(){
        bookService.deleteBook("1");
    }

    @Test
    public void testJdbcTemplate4(){
        int count = bookService.findCount();
        System.out.println(count);
    }

    @Test
    public void testJdbcTemplate5(){
        Book book = bookService.findOne("1");
        System.out.println(book);
    }

    @Test
    public void testJdbcTemplate6(){
        List<Book> list = bookService.findList();
        list.forEach(System.out::println);
    }

    @Test
    public void testJdbcTemplate7(){
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"3","java","A"};
        Object[] o2 = {"4","C++","B"};
        Object[] o3 = {"5","MySQL","C"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        // 调用批量添加方法
        bookService.batchAdd(batchArgs);
    }

    @Test
    public void testJdbcTemplate8(){
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"java3","B","3"};
        Object[] o2 = {"C++4","C","4"};
        Object[] o3 = {"MySQL5","A","5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        // 调用批量修改方法
        bookService.batchUpdate(batchArgs);
    }

    @Test
    public void testJdbcTemplate9(){
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"3"};
        Object[] o2 = {"4"};
        Object[] o3 = {"5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        // 调用批量删除方法
        bookService.batchDelete(batchArgs);
    }

}
