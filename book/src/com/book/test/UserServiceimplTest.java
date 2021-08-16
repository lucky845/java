package com.book.test;

import com.book.pojo.User;
import com.book.server.UserService;
import com.book.server.impl.UserServiceimpl;
import org.junit.Test;

/**
 * @author lichuang
 * @create 2021-08-14 17:28
 */
public class UserServiceimplTest {

    UserService userService = new UserServiceimpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"bbj168","666666","bbj168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"bbj168","666666","bbj168@qq.com")));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("bbj16888")){
            System.out.println("用户名已经存在！");
        }else {
            System.out.println("用户名可用！");
        }
    }
}