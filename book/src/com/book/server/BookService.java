package com.book.server;

import com.book.pojo.Book;

import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-16 19:04
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

}
