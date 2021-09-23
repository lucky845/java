package com.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @ClassName: JToolBarTest3
 * @Description:
 * @Date: 2021/9/23 17:26
 * @Author lichuang
 * @Since JDK 1.8
 */
public class JToolBarTest3 {

    JFrame jf = new JFrame("测试工具条");
    JTextArea jta = new JTextArea(6,35);

    // 声明工具条相关内容
    JToolBar jToolBar = new JToolBar("播放工具条",SwingConstants.HORIZONTAL);

    // 创建3个Action对象

    //创建"上一曲"Action,该Action用于创建工具按钮
    // 传递的参数：name和icon，最终在添加到工具条中时，会被拿出来当作名称和图标
    Action pre = new AbstractAction("上一曲",new ImageIcon("Swing\\img\\component\\pre.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("上一曲.\n");
        }
    };
    //创建"暂停" Action
    Action pause = new AbstractAction("暂停",new ImageIcon("Swing\\img\\component\\pause.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("暂停播放.\n");
        }
    };
    //创建"下一曲" Action
    Action next = new AbstractAction("下一曲",new ImageIcon("Swing\\img\\component\\next.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("下一曲.\n");
        }
    };


    public void init(){
        // 组装视图

        // 通过Action对象添加JButton
        JButton preBtn = new JButton(pre);
        JButton pauseBtn = new JButton(pause);
        JButton nextBtn = new JButton(next);

        //给JTextArea添加滚动条(文本框默认不支持滚动条)
        // 将一个组件添加到JScrollPane中就支持滚动条了
        jf.add(new JScrollPane(jta));

        // 以Action的形式创建按钮，并将按钮添加到Panel中
//        jToolBar.add(pre);
//        jToolBar.addSeparator();
//        jToolBar.add(pause);
//        jToolBar.addSeparator();
//        jToolBar.add(next);

        jToolBar.add(preBtn);
        jToolBar.addSeparator();
        jToolBar.add(pauseBtn);
        jToolBar.addSeparator();
        jToolBar.add(nextBtn);

        // 让工具条可以拖动
        jToolBar.setFloatable(true);

        //向窗口中添加工具条
        jf.add(jToolBar, BorderLayout.NORTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JToolBarTest3().init();
    }
}
