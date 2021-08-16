package com.book.server;

import com.book.pojo.User;

/**
 * @author lichuang
 * @create 2021-08-14 17:13
 */
public interface UserService {

    /**
     * 注册用户
     * @Author lichuang
     * @Date 2021/8/14 17:15
     * @param user
     * @return void
     */
    public void registUser(User user);

    /**
     * 登录
     * @Author lichuang
     * @Date 2021/8/14 17:16
     * @param user
     * @return com.book.pojo.User 如果返回null，说明登录失败，返回有值，说明登陆成功
     */
    public User login(User user);

    /**
     * 检查 用户名是否可用
     * @Author lichuang
     * @Date 2021/8/14 17:17
     * @param username
     * @return boolean 返回false表示用户名已存在，返回true表示用户名可用
     */
    public boolean existsUsername(String username);

}
