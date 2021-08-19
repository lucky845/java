package com.book.dao;

import com.book.pojo.User;

/**
 * @author lichuang
 * @description
 * @create 2021-08-14 15:58
 */
public interface UserDAO {

    /**
     * 根据 用户名 查询用户信息
     * @param username 用户名
     * @return com.book.pojo.User 如果返回null，说明没有这个用户,反之亦然
     * @Author lichuang
     * @Date 2021/8/14 16:00
     */
    public User queryUserByUsername(String username);

    /**
     * 根据 用户名和密码 查询用户
     * @param username
     * @param password
     * @return com.book.pojo.User 如果返回null，说明用户名或密码错误,反之亦然
     * @Author lichuang
     * @Date 2021/8/14 16:03
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user
     * @return int 返回-1表示操作失败，其他是sql语句的影响行数
     * @Author lichuang
     * @Date 2021/8/14 16:02
     */
    public int saveUser(User user);

    String queryUserById(Integer id);
}
