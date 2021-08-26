package com.spring5.test;

import com.spring5.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lichuang
 * @create 2021-08-26 19:37
 * @project_name spring5
 */
@RunWith(SpringJUnit4ClassRunner.class) // 单元测试框架
@ContextConfiguration("classpath:bean1.xml") // 加载配置文件
public class JTest4 {

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        userService.accountMoney();
    }

}
