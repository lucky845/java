package com.book.dao.impl;

import com.book.dao.BaseDAO;
import com.book.dao.UserDAO;
import com.book.pojo.User;

/**
 * @author lichuang
 * @create 2021-08-14 16:06
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO t_user(`username`,`password`,`email`)VALUES(?,?,?);";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public String queryUserById(Integer id) {
        String sql = "select username from t_user where id = ?";
        String username = (String) queryForSingleValue(sql, id);
        return username;
    }
}
