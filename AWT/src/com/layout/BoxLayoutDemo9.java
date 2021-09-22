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

        // 1.创建一个横向的Box并放上三个按钮
        Box hBox = Box.createHorizontalBox();
        hBox.add(new Button("水平按钮一"));
        hBox.add(Box.createHorizontalGlue());//两个方向都可以拉伸的间隔
        hBox.add(new Button("水平按钮二"));
        hBox.add(Box.createHorizontalStrut(10));//水平间隔固定，垂直间方向可以拉伸
        hBox.add(new Button("水平按钮3"));

        // 2.创建一个垂直Box并放上三个按钮
        Box vBox = Box.createVerticalBox();
        vBox.add(new Button("垂直按钮一"));
        hBox.add(Box.createHorizontalGlue());//两个方向都可以拉伸的间隔
        vBox.add(new Button("垂直按钮二"));
        hBox.add(Box.createHorizontalStrut(10));//水平间隔固定，垂直间方向可以拉伸
        vBox.add(new Button("垂直按钮三"));

        // 3.将这两个Box添加到frame容器中
        frame.add(hBox,BorderLayout.NORTH);
        frame.add(vBox);

        // 4.设置格式化最佳大小，并使容器可见
        frame.pack();
        frame.setVisible(true);
    }
}
