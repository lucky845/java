package com.spring5.dao;

import com.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-25 17:34
 * @project_name spring5
 */
@Repository
public class BookDaoImpl implements BookDao{

    // 注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加的方法
    @Override
    public void add(Book book) {
        Object[] args = {book.getId(), book.getName(), book.getStatus()};
        // 1.创建sql语句
        String sql = "insert into t_book values(?,?,?)";
        // 2.调用方法实现
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    // 修改的方法
    @Override
    public void update(Book book) {
        Object[] args = {book.getName(), book.getStatus(),book.getId()};
        // 1.创建sql语句
        String sql = "update t_book set name=?,status=? where id=?";
        // 2.调用方法实现
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    // 删除的方法
    @Override
    public void delete(String id) {
        // 1.创建sql语句
        String sql = "delete from t_book where id=?";
        // 2.调用方法实现
        int update = jdbcTemplate.update(sql,id);
        System.out.println(update);
    }

    // 查询表中的记录数
    @Override
    public int selectCount() {
        String sql = "select count(*) from t_book";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    // 查询返回对象的方法
    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from t_book where id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),id);
    }

    // 查询返回集合
    @Override
    public List<Book> findAllBook() {
        String sql = "select * from t_book";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
    }

    // 批量添加
    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into t_book values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    // 批量修改
    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        String sql = "update t_book set name=?,status=? where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    // 批量删除
    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {
        String sql = "delete from t_book where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}
