package com.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @ClassName: ConfirmDialogTest7
 * @Description:
 * @Date: 2021/9/24 20:31
 * @Author lichuang
 * @Since JDK 1.8
 */
public class ConfirmDialogTest7 {

    JFrame jFrame = new JFrame("测试确认对话框");

    JTextArea jta = new JTextArea("hello china",6,30);

    JButton jb = new JButton(new AbstractAction("确认弹出对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(jFrame, jta.getText(), "确认对话框", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                jta.append("\n用户点击了确认按钮");
            }
            if(result == JOptionPane.NO_OPTION){
                jta.append("\n用户点击了取消按钮");
            }
        }
    });

    public void init(){

        jFrame.add(jta);
        jFrame.add(jb, BorderLayout.SOUTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

    }

    public static void main(String[] args) {
        new ConfirmDialogTest7().init();
    }

}
