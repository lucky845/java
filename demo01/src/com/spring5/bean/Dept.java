package com.spring5.bean;

/**
 * 部门类
 *
 * @author lichuang
 * @create 2021-08-22 18:25
 * @project_name spring5
 */
public class Dept {

    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
