package com.spring5.bean;

/**
 * 员工类
 *
 * @author lichuang
 * @create 2021-08-22 18:26
 * @project_name spring5
 */
public class Emp {
    private String ename;
    private String gender;
    // 员工属于员工部门，使用对象形式表示
    private Dept dept;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    public void add(){
        System.out.println(ename + "::" + gender + "::" + dept);
    }
}
