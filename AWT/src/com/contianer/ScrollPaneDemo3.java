package com.contianer;

import java.awt.*;

/**
 * @ClassName: ScrollPaneDemo
 * @Description:
 * @Date: 2021/9/11 16:15
 * @Author lichuang
 * @Since JDK 1.8
 */
public class ScrollPaneDemo3 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试ScrollPane窗口");

        // 1.创建一个ScrollPane对象
        ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS); // 构造器参数设置总是有滚动条
        // 2.往ScrollPane中添加内容
        scrollPane.add(new TextField("测试文本框"));
        scrollPane.add(new Button("测试按钮"));
        // 3.将ScrollPane添加到Frame中
        frame.add(scrollPane);

        frame.setBounds(100,100,500,300);
        frame.setVisible(true);
    }
}
