package com.book.dao.impl;

import com.book.dao.BaseDAO;
import com.book.dao.BookDAO;
import com.book.pojo.Book;

import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-16 18:25
 */
public class BookDAOImpl extends BaseDAO implements BookDAO {

    @Override
    public int addBook(Book book) {

        String sql = "insert into t_book(`name`, `author`, `price`, `sales`, `stock`, `img_path`)values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgpath());
    }

    @Override
    public int deleteBookById(Integer id) {

        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {

        String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id = ? ";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgpath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {

        String sql = "select `id`,`name`, `author`, `price`, `sales`, `stock`, `img_path` imgpath  from t_book where id = ?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {

        String sql = "select `id`,`name`, `author`, `price`, `sales`, `stock`, `img_path` imgpath  from t_book";
        return queryForList(Book.class,sql);
    }
}
