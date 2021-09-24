package com.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @ClassName: OptionPaneDialogTest9
 * @Description:
 * @Date: 2021/9/24 21:11
 * @Author lichuang
 * @Since JDK 1.8
 */
public class OptionPaneDialogTest9 {

    JFrame jFrame = new JFrame("测试选项对话框");

    JTextArea jta  = new JTextArea(6,30);

    JButton jb = new JButton(new AbstractAction("选择对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showOptionDialog(jFrame, "请选择尿不湿号码", "选项对话框", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, new String[]{"大号", "中号", "小号"}, "中号");
            switch(result){
                case 0:
                    jta.setText("用户选择了大号尿不湿");
                    break;
                case 1:
                    jta.setText("用户选择了中号尿不湿");
                    break;
                case 2:
                    jta.setText("用户选择了小号尿不湿");
                    break;
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
        new OptionPaneDialogTest9().init();
    }

}
