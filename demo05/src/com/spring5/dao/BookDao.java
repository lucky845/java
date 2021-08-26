package com.spring5.dao;

import com.spring5.entity.Book;

import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-25 17:34
 * @project_name spring5
 */
public interface BookDao {
    // 添加的方法
    void add(Book book);

    void update(Book book);

    void delete(String id);

    int selectCount();

    Book findBookInfo(String id);

    List<Book> findAllBook();

    void batchAddBook(List<Object[]> batchArgs);

    void batchUpdateBook(List<Object[]> batchArgs);

    void batchDeleteBook(List<Object[]> batchArgs);
}
