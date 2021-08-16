package com.book.dao;

import com.book.pojo.Book;

import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-16 18:19
 */
public interface BookDAO {

    /**
     * 添加图书
     * @Author lichuang
     * @Date 2021/8/16 18:52
     * @param book
     * @return int
     */
    public int addBook(Book book);

    /**
     * 删除图书
     * @Author lichuang
     * @Date 2021/8/16 18:52
     * @param id
     * @return int
     */
    public int deleteBookById(Integer id);

    /**
     * 修改图书
     * @Author lichuang
     * @Date 2021/8/16 18:53
     * @param book
     * @return int
     */
    public int updateBook(Book book);

    /**
     * 通过id查询单本图书
     * @Author lichuang
     * @Date 2021/8/16 18:53
     * @param id
     * @return com.book.pojo.Book
     */
    public Book queryBookById(Integer id);

    /**
     * 查询多本图书
     * @Author lichuang
     * @Date 2021/8/16 18:53
     * @param
     * @return java.util.List<com.book.pojo.Book>
     */
    public List<Book> queryBooks();

}
