package com.layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: CardLayoutDemo6
 * @Description:
 * @Date: 2021/9/11 18:43
 * @Author lichuang
 * @Since JDK 1.8
 */
public class CardLayoutDemo6 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试CardLayout");

        // 1.创建Panel,用来存放多张卡片
        Panel p1 = new Panel();
        // 2.创建CardLayout对象，并把该对象设置给之前的容器
        CardLayout cardLayout = new CardLayout();
        p1.setLayout(cardLayout);
        // 3.往panel中存放多个组件
        String[] names = {"第一张","第二张","第三张","第四张","第五张"};
        for (String name : names) {
            p1.add(name, new Button(name));
        }
        // 4.把panel放到Frame的中间区域
        frame.add(p1);
        // 5.创建另一个panel p2，用来存放多个按钮组件
        Panel p2 = new Panel();
        // 6、创建5个按钮组件
        Button b1 = new Button("上一张");
        Button b2 = new Button("下一张");
        Button b3 = new Button("第一张");
        Button b4 = new Button("最后一张");
        Button b5 = new Button("第三张");
        // 7、创建一个事物监听器，监听按钮的点击动作
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand(); // 这个字符串就是按钮上的文字
                switch(actionCommand){
                    case "上一张":
                        cardLayout.previous(p1);
                        break;
                    case "下一张":
                        cardLayout.next(p1);
                        break;
                    case "第一张":
                        cardLayout.first(p1);
                        break;
                    case "最后一张":
                        cardLayout.last(p1);
                        break;
                    case "第三张":
                        cardLayout.show(p1,"第三张");
                        break;
                }
            }
        };
        // 8、将这个事件监听器与按钮绑定起来
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
        // 9、把按钮添加到容器中
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        // 10、把p2添加到Frame南边区域
        frame.add(p2,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
