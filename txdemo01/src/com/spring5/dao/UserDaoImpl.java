package com.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author lichuang
 * @create 2021-08-26 15:51
 * @project_name spring5
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 多钱的方法
     */
    @Override
    public void addMoney() {
        String sql = "update t_account set money=money-? where username=?";
        jdbcTemplate.update(sql,100,"lucy");
    }

    /**
     * 少钱的方法
     */
    @Override
    public void reduceMoney() {
        String sql = "update t_account set money=money+? where username=?";
        jdbcTemplate.update(sql,100,"mary");
    }
}
