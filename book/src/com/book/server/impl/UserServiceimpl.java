package com.book.server.impl;

import com.book.dao.UserDAO;
import com.book.dao.impl.UserDAOImpl;
import com.book.pojo.User;
import com.book.server.UserService;

/**
 * @author lichuang
 * @create 2021-08-14 17:18
 */
public class UserServiceimpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void registUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDAO.queryUserByUsername(username) == null){
            // 等于null,说明没有查到,没查到表示可用
            return false;
        }
        return true;
    }
}
