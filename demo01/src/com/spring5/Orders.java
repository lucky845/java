package com.spring5;

/**
 * 使用有参构造器注入属性
 * @author lichuang
 * @create 2021-08-22 16:56
 * @project_name spring5
 */
public class Orders {
    // 属性
    private String oname;
    private String address;

    // 有参数的构造器
    public Orders(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }

    public void ordersTest(){
        System.out.println(oname + "::" + address);
    }
}
