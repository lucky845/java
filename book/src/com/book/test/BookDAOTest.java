package com.book.test;

import com.book.dao.BookDAO;
import com.book.dao.impl.BookDAOImpl;
import com.book.pojo.Book;
import com.book.pojo.Page;
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

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDAO.queryForPageTotalCount());
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDAO.queryForPageTotalCountByPrice(10,50));
    }

    @Test
    public void queryForPageItems() {
        for (Book book : bookDAO.queryForPageItems(2, Page.PAGE_SIZE)) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageItemsByPrice() {
        for (Book book : bookDAO.queryForPageItemsByPrice(2, Page.PAGE_SIZE,10,50)) {
            System.out.println(book);
        }
    }
}