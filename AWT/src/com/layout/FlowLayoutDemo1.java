package com.layout;

import java.awt.*;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName: FlowLayoutDemo
 * @Description:
 * @Date: 2021/9/11 16:38
 * @Author lichuang
 * @Since JDK 1.8
 */
public class FlowLayoutDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试FlowLayout");

        // 1.通过setLayout()方法设置容器的布局管理器
//        frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,20)); // 左对齐
//        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); // 右对齐
//        frame.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20)); // 居中对齐
        // 2.添加多个按钮到Frame中
        for (int i = 1; i <= 100; i++) {
            frame.add(new Button("测试按钮" + i));
        }
        // 3.设置最佳大小，pack()方法
        frame.pack();

        frame.setBounds(100,100,500,300);
        frame.setVisible(true);
    }


}
