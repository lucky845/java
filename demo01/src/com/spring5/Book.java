package com.spring5;

/**
 * 演示使用set方法进行注入属性
 * @author lichuang
 * @create 2021-08-22 16:36
 * @project_name spring5
 */
public class Book {
    // 创建属性
    private String bname;
    private String bauthor;
    private String address;

    // set 方法注入
    public void setBname(String bname) {
        this.bname = bname;
    }
    public void setBauthor(String bauthor){
        this.bauthor = bauthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void testDemo(){
        System.out.println(bname + "::" + bauthor + "::" + address);
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.setBname("abc");
    }
}
