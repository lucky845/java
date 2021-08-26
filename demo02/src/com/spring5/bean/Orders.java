package com.spring5.bean;

/**
 * @author lichuang
 * @create 2021-08-23 18:37
 * @project_name spring5
 */
public class Orders {
    private String oname;

    // 无参构造
    public Orders() {
        System.out.println("第一步 执行无参构造函数");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步 调用set方法设置属性值");
    }

    // 创建执行的初始化方法
    public void initMethod(){
        System.out.println("第三步 执行初始化的方法");
    }
    // 创建执行的销毁方法
    public void destroyMethod(){
        System.out.println("第五步 执行销毁的方法");
    }
}
