package com.spring5.collectiontype;

import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-22 19:41
 * @project_name spring5
 */
public class Book {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void test(){
        System.out.println(list);
    }
}
