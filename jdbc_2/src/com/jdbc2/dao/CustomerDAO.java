package com.jdbc2.dao;

import com.jdbc2.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author lichuang
 * @description 此接口用于规范针对customers表的常用操作
 * @create 2021-08-09 15:21
 */
public interface CustomerDAO {
    /***
     * @Author lichuang
     * @Description //TODO 将cust对象添加到数据库中
     * @Date 2021/8/9 15:25
     * @param conn
     * @param cust
     * @return void
     */
    void insert(Connection conn, Customer cust);

    /***
     * @Author lichuang
     * @Description //TODO 针对指定的Id，删除数据表中对应的一条数据
     * @Date 2021/8/9 15:26
     * @param conn
     * @param id
     * @return void
     */
    void deleteById(Connection conn,int id);

    /***
     * @Author lichuang
     * @Description //TODO 根据内存中的cust对象，修改数据表中指定的记录
     * @Date 2021/8/9 15:27
     * @param conn
     * @param cust
     * @return void
     */
    void updateById(Connection conn,Customer cust);

    /***
     * @Author lichuang
     * @Description //TODO 针对数据表中指定的id查询得到对应的Customer对象
     * @Date 2021/8/9 15:29
     * @param conn
     * @param id
     * @return void
     */
    Customer getCustomerById(Connection conn,int id);

    /***
     * @Author lichuang
     * @Description //TODO 查询数据表中所有记录构成的集合
     * @Date 2021/8/9 15:32
     * @param conn
     * @return java.util.List<com.jdbc2.bean.Customer>
     */
    List<Customer> getAll(Connection conn);

    /***
     * @Author lichuang
     * @Description //TODO 返回数据表中数据的条目数
     * @Date 2021/8/9 15:33
     * @param conn
     * @return java.lang.Long
     */
    Long getCount(Connection conn);

    /***
     * @Author lichuang
     * @Description //TODO 返回数据表中最大的生日
     * @Date 2021/8/9 15:34
     * @param conn
     * @return Date
     */
    Date getMaxBirth(Connection conn);



}
