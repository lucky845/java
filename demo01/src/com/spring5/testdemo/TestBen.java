package com.spring5.testdemo;

import com.spring5.User;
import com.spring5.bean.Emp;
import com.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lichuang
 * @create 2021-08-22 18:20
 * @project_name spring5
 */
public class TestBen {

    @Test
    public void testBean1() {
        // 1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        // 2.获取创建的对象
        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService);
        userService.Add();
    }

    @Test
    public void testBean2(){
        // 1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        // 2.获取创建的对象
        Emp emp = context.getBean("emp", Emp.class);

        emp.add();
    }

    @Test
    public void testBean3(){
        // 1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        // 2.获取创建的对象
        Emp emp = context.getBean("emp", Emp.class);

        emp.add();
    }

}
