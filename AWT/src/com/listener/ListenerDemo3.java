package com.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @ClassName: ListenerDemo2
 * @Description:
 * @Date: 2021/9/22 13:56
 * @Author lichuang
 * @Since JDK 1.8
 */
public class ListenerDemo3 {

    public static void main(String[] args) {
        Frame frame = new Frame("这里测试WindowListener");


        // 监听用户点击关闭的操作
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 停止当前程序
                System.exit(0);
            }
        });

        frame.setBounds(200,200,500,300);

        frame.setVisible(true);
    }
}
