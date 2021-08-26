package com.spring5.factorybean;

import com.spring5.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lichuang
 * @create 2021-08-23 17:45
 * @project_name spring5
 */
public class MyBean implements FactoryBean<Course> {

    // 定义返回bean对象
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
