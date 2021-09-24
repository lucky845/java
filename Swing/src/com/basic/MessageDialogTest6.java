package com.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @ClassName: MessageDialogTest6
 * @Description:
 * @Date: 2021/9/24 18:56
 * @Author lichuang
 * @Since JDK 1.8
 */
public class MessageDialogTest6 {

    JFrame jFrame = new JFrame("测试四种消息弹窗");

    JTextArea jTextArea = new JTextArea("hello china",6,30);

    // 声明按钮
    JButton jb = new JButton(new AbstractAction("弹出消息对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 弹出一个消息对话框
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.WARNING_MESSAGE);
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.QUESTION_MESSAGE);
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(jFrame, jTextArea.getText(), "消息对话框", JOptionPane.WARNING_MESSAGE, new ImageIcon("Swing\\img\\component\\female.png"));
        }
    });


    public void init(){

        jFrame.add(jb);
        jFrame.add(jTextArea, BorderLayout.NORTH);

        // 常规操作
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new MessageDialogTest6().init();
    }


}
