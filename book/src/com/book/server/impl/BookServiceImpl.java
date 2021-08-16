package com.book.server.impl;

import com.book.dao.BookDAO;
import com.book.dao.impl.BookDAOImpl;
import com.book.pojo.Book;
import com.book.server.BookService;

import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-16 19:07
 */
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDAO.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAO.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDAO.queryBooks();
    }
}
