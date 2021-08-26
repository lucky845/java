package com.spring5.collectiontype;

/**
 * 课程类
 * @author lichuang
 * @create 2021-08-22 19:22
 * @project_name spring5
 */
public class Course {
    private String cname; // 课程名称

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
