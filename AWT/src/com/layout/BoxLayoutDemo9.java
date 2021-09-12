package com.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: BoxLayoutDemo8
 * @Description:
 * @Date: 2021/9/11 20:13
 * @Author lichuang
 * @Since JDK 1.8
 */
public class BoxLayoutDemo9 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试BoxLayout");

        // 1.创建一个水平排列组件的Box容器
        Box hBox = Box.createHorizontalBox();
        // 2.往当前容器添加两个按钮
        hBox.add(new Button("水平按钮1"));
        hBox.add(new Button("水平按钮2"));
        // 3.创建一个垂直排列组件的Box容器
        Box vBox = Box.createVerticalBox();
        // 4.往当前容器添加两个按钮
        vBox.add(new Button("垂直按钮1"));
        vBox.add(new Button("垂直按钮2"));
        // 5.把两个容器添加到Frame中展示
        frame.add(hBox,BorderLayout.NORTH); // 北边区域
        frame.add(vBox,BorderLayout.SOUTH); // 南边区域

        frame.pack();
        frame.setVisible(true);
    }
}
