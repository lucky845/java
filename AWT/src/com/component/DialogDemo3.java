package com.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: DialogDemo2
 * @Description:
 * @Date: 2021/9/22 12:11
 * @Author lichuang
 * @Since JDK 1.8
 */
public class DialogDemo3 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试Dialog");

        // 1.创建两个Dialog对话框，一个模式化的一个非模式化的
        Dialog d1 = new Dialog(frame, "模式化窗口", true);

        // 创建一个垂直的Box容器
        Box vBox = Box.createVerticalBox();
        vBox.add(new TextField(20));
        vBox.add(new Button("确认"));

        // 将vBox添加到对话框中
        d1.add(vBox);

        // 2.通过setBounds方法设置组件的位置和大小
        d1.setBounds(20,30,200,300);

        // 3.创建两个按钮
        Button b1 = new Button("打开模式对话框");

        // 4.需要给两个按钮添加点击后的行为
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
            }
        });

        // 5.将按钮添加到frame中
        frame.add(b1,BorderLayout.NORTH);

        // 设置最佳大小，并设置可见
        frame.pack();
        frame.setVisible(true);
    }
}
