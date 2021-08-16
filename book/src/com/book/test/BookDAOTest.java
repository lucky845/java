package com.book.test;

import com.book.dao.BookDAO;
import com.book.dao.impl.BookDAOImpl;
import com.book.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author lichuang
 * @create 2021-08-16 18:50
 */
public class BookDAOTest {

    private BookDAO bookDAO = new BookDAOImpl();

    @Test
    public void addBook() {
        bookDAO.addBook(new Book(null,"我为什么这么帅!","191125",new BigDecimal(999),1000000,0,null));
    }

    @Test
    public void deleteBookById() {
        bookDAO.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDAO.updateBook(new Book(21,"大家都可以这么帅!","19111",new BigDecimal(999),1000000,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDAO.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBooks: bookDAO.queryBooks()) {
            System.out.println(queryBooks);
        }
    }
}