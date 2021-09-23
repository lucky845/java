package com.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @ClassName: JColorChooserDemo4
 * @Description:
 * @Date: 2021/9/23 18:04
 * @Author lichuang
 * @Since JDK 1.8
 */
public class JColorChooserDemo4 {

    JFrame jFrame = new JFrame("测试颜色选择器");

    JTextArea jta = new JTextArea("我爱中华",6,30);

    // 声明按钮
    JButton btn = new JButton(new AbstractAction("改变文本框背景颜色") {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 弹出一个颜色选择器
            Color result = JColorChooser.showDialog(jFrame, "颜色选择器", Color.WHITE);
            // 修改文本框背景
            jta.setBackground(result);
        }
    });

    public void init(){
        // 组装视图，实现逻辑
        jFrame.add(jta);

        jFrame.add(btn,BorderLayout.SOUTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new JColorChooserDemo4().init();
    }

}
