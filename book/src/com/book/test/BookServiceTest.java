package com.book.test;

import com.book.pojo.Book;
import com.book.server.BookService;
import com.book.server.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author lichuang
 * @create 2021-08-16 19:10
 */
public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"天下我有！","1125",new BigDecimal(999),100000,0,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"山河社稷图！","11255",new BigDecimal(999),10,0,null));
    }

    @Test
    public void queryUserById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }
}