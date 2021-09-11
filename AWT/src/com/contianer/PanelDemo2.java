package com.contianer;

import java.awt.*;

/**
 * @ClassName: PanelDemo
 * @Description:
 * @Date: 2021/9/11 15:55
 * @Author lichuang
 * @Since JDK 1.8
 */
public class PanelDemo2 {
    public static void main(String[] args) {
        // 1.创建一个window对象，因为panel以及其他容器都不能独立存在，必须依赖window对象
        Frame frame = new Frame("测试panel窗口");
        // 2.创建一个Panel容器对象
        Panel panel = new Panel();
        // 3.创建一个文本框和一个按钮并放到Panel容器中
        panel.add(new TextField("这里是一个测试文本框"));
        panel.add(new Button("这里是一个测试按钮")); // awt会出现gbk乱码，使用Swing下的JButton就不会乱码
        // 4.把panel放到window中
        frame.add(panel);
        // 5.设置window的位置和大小
        frame.setBounds(100,100,500,300);
        // 6.设置window可见
        frame.setVisible(true);
    }
}
