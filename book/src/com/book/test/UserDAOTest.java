package com.book.test;

import com.book.dao.UserDAO;
import com.book.dao.impl.UserDAOImpl;
import com.book.pojo.User;
import org.junit.Test;

/**
 * @author lichuang
 * @create 2021-08-14 16:37
 */
public class UserDAOTest {

    UserDAO userDAO = new UserDAOImpl();

    @Test
    public void queryUserByUsername() {

        if(userDAO.queryUserByUsername("admin") == null){
            System.out.println("用户名可用!");
        }else {
            System.out.println("用户名已存在!");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {

        if (userDAO.queryUserByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名或密码错误，登录失败");
        }else{
            System.out.println("登陆成功");
        }
    }

    @Test
    public void saveUser() {

        System.out.println(userDAO.saveUser(new User(null,"1224443","123456","admin@qq.com")));
    }
}