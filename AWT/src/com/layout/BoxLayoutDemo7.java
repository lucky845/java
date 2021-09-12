package com.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: BoxLayoutDemo7
 * @Description:
 * @Date: 2021/9/11 19:53
 * @Author lichuang
 * @Since JDK 1.8
 */
public class BoxLayoutDemo7 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试BoxLayout");

        // 1.基于Frame容器，创建一个BoxLayout对象，并且该对象存放组件是垂直存放
//        BoxLayout boxLayout = new BoxLayout(frame,BoxLayout.Y_AXIS);
        BoxLayout boxLayout = new BoxLayout(frame,BoxLayout.X_AXIS);
        // 2.将BoxLayout设置到Frame
        frame.setLayout(boxLayout);
        // 3.在Frame中添加两个按钮组件
        frame.add(new Button("按钮1"));
        frame.add(new Button("按钮2"));

        frame.pack();
        frame.setVisible(true);
    }
}
