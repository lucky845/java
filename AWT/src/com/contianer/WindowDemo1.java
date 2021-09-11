package com.contianer;

import java.awt.*;

/**
 * @ClassName: Window
 * @Description:
 * @Date: 2021/9/11 15:43
 * @Author lichuang
 * @Since JDK 1.8
 */
public class WindowDemo1 {
    public static void main(String[] args) {
        // 1.创建一个窗口对象
        Frame frame = new Frame("这里创建window窗口");
        // 2.指定窗口的位置，大小
        frame.setLocation(100,100);
        frame.setSize(500,300);
        // 3.设置窗口可见
        frame.setVisible(true);

    }

}
