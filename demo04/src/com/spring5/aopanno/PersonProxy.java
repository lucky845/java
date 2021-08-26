package com.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 被增强类
 * @author lichuang
 * @create 2021-08-25 15:00
 * @project_name spring5
 */
@Component
@Aspect
@Order(1)
public class PersonProxy {
    // 前置通知
    @Before(value = "execution(* com.spring5.aopanno.User.add(..))")
    public void afterReturning(){
        System.out.println("PersonProxy before.......");
    }
}
