package com.spring5.dao;

import org.springframework.stereotype.Repository;

/**
 * @author lichuang
 * @create 2021-08-24 19:00
 * @project_name spring5
 */
@Repository(value = "userService1")
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("Dao add..........");
    }
}
