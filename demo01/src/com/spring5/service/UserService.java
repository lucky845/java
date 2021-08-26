package com.spring5.service;

import com.spring5.dao.UserDao;
import com.spring5.dao.UserDaoImpl;

/**
 * @author lichuang
 * @create 2021-08-22 17:59
 * @project_name spring5
 */
public class UserService {

    // 创建UserDao类型属性，生成set方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void Add(){
        System.out.println("service add...........");
        userDao.update();

        // 原始方式创建UserDao对象
//        UserDao userDao = new UserDaoImpl();
//        userDao.update();
    }

}
