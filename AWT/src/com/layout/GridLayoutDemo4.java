package com.layout;

import java.awt.*;

/**
 * @ClassName: GridLayoutDemo4
 * @Description: 计算器
 * @Date: 2021/9/11 18:01
 * @Author lichuang
 * @Since JDK 1.8
 */
public class GridLayoutDemo4 {
    public static void main(String[] args) {
        Frame frame = new Frame("计算器");

        // 1.创建一个Panel对象，里面存放一个TextField组件
        Panel panel = new Panel();
        panel.add(new TextField(30));
        // 2.把当前Panel添加到Frame的北边区域
        frame.add(panel,BorderLayout.NORTH);
        // 3.创建一个Panel对象，并且设置布局管理器为GridLayout
        Panel panel2 = new Panel();
        panel2.setLayout(new GridLayout(3,5,4,4));
        // 4.向Panel中添加内容
        for (int i = 0; i < 10; i++) {
            panel2.add(new Button(i + ""));
        }
        panel2.add(new Button("+"));
        panel2.add(new Button("-"));
        panel2.add(new Button("*"));
        panel2.add(new Button("/"));
        panel2.add(new Button("."));
        // 5.将当前Panel加入到Frame
        frame.add(panel2);

        frame.pack();
        frame.setVisible(true);

    }
}
