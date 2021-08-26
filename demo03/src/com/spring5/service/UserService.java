package com.spring5.service;

import com.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lichuang
 * @create 2021-08-24 18:37
 * @project_name spring5
 */
// 注解里面value属性值可以省略不写
    // 默认值是类名称，首字母小写
//@Component(value="userService")  // <bean id="userService" class="...."/>
 @Service
public class UserService {

     @Value(value = "abc")
     private String name;

     // 定义dao类型属性
    // 不需要添加set方法
    // 添加注入属性的注解
//    @Autowired // 根据类型进行注入
//    @Qualifier(value="userService1") // 根据名称注入
//    private UserDao userDao;

//    @Resource // 根据类型注入
    @Resource(name = "userService1") // 根据名称注入
    private UserDao userDao;

    public void add(){
        System.out.println("service add............" + name);
        userDao.add();

    }
}
