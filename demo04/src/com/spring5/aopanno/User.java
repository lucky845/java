package com.spring5.aopanno;

import org.springframework.stereotype.Component;

/**
 * 被增强类
 * @author lichuang
 * @create 2021-08-25 15:00
 * @project_name spring5
 */
@Component
public class User {
    public void add(){
        System.out.println("user add.......");
//        throw new RuntimeException();
    }
}
