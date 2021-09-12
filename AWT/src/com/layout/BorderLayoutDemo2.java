package com.layout;

import java.awt.*;

/**
 * @ClassName: BorderLayoutDemo2
 * @Description:
 * @Date: 2021/9/11 17:00
 * @Author lichuang
 * @Since JDK 1.8
 */
public class BorderLayoutDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试BorderLayout");

        // 1.给Frame设置BorderLayout布局管理器
        frame.setLayout(new BorderLayout(30,10));
        // 2.往Frame指定区域添加组件
        frame.add(new Button("北侧按钮"), BorderLayout.NORTH);
        frame.add(new Button("南侧按钮"), BorderLayout.SOUTH);
        frame.add(new Button("西侧按钮"), BorderLayout.WEST);
        frame.add(new Button("东侧按钮"), BorderLayout.EAST);
        frame.add(new Button("中间按钮"), BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
