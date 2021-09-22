package com.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: FileDialogDemo4
 * @Description:
 * @Date: 2021/9/22 12:38
 * @Author lichuang
 * @Since JDK 1.8
 */
public class FileDialogDemo4 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试文件对话框FileDialog");

        // 1.创建两个FileDialog对象
        FileDialog f1 = new FileDialog(frame,"选择要打开的文件",FileDialog.LOAD);
        FileDialog f2 = new FileDialog(frame,"选择要保存的文件",FileDialog.SAVE);

        // 2.创建两个按钮
        Button b1 = new Button("打开文件");
        Button b2 = new Button("保存文件");

        // 3.给按钮绑定单击事件，获取打开或保存的文件名
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true); // 代码会阻塞在这里

                // 获取选择的文件及路径
                String directory = f1.getDirectory();
                String file = f1.getFile();
                System.out.println("打开的文件路径为" + directory + "，打开的文件名为" + file);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(true); // 代码会阻塞在这里

                // 获取选择的文件及路径
                String directory = f2.getDirectory();
                String file = f2.getFile();
                System.out.println("保存的文件路径为" + directory + "，保存的文件名为" + file);
            }
        });

        // 4.将按钮添加到frame中
        frame.add(b1,BorderLayout.NORTH);
        frame.add(b2,BorderLayout.SOUTH);

        // 设置最佳大小，并设置可见
        frame.pack();
        frame.setVisible(true);
    }
}
