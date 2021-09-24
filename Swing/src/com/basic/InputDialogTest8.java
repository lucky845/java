package com.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @ClassName: InputDialogTest8
 * @Description:
 * @Date: 2021/9/24 20:51
 * @Author lichuang
 * @Since JDK 1.8
 */
public class InputDialogTest8 {

    JFrame jFrame = new JFrame("测试输入对话框");

    JTextArea jta = new JTextArea(6,30);

    JButton jb = new JButton(new AbstractAction("弹出输入对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 输入对话框
//            String result = JOptionPane.showInputDialog(jFrame, "请填写您的银行账号：", "输入对话框", JOptionPane.INFORMATION_MESSAGE);
//            if(result != null){
//                jta.append(result.toString());
//            }
            // 选择对话框
            Object result = JOptionPane.showInputDialog(jFrame, "", "选择对话框", JOptionPane.DEFAULT_OPTION, null, new String[]{"柳岩", "舒淇", "龚玥菲"}, "舒淇");
            if(result != null){
                jta.append(result.toString());
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
        new InputDialogTest8().init();
    }
}
