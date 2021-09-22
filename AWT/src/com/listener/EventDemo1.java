package com.listener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.ValueRange;

/**
 * @ClassName: EventDemo1
 * @Description:
 * @Date: 2021/9/22 13:20
 * @Author lichuang
 * @Since JDK 1.8
 */
public class EventDemo1 {
    Frame frame = new Frame("测试事件处理");
    TextField tf = new TextField(30);
    // 事件源
    Button ok = new Button("确定");

    public void init(){
        // 组装视图
        // 监听器
//        MyListener myListener = new MyListener();

        // 注册监听
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok按钮被点击了……");
                tf.setText("HelloWorld");
            }
        });

        // 把tf和ok放入frame中
        frame.add(tf,BorderLayout.NORTH);
        frame.add(ok,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

//    private class MyListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            tf.setText("Hello World");
//        }
//    }

    public static void main(String[] args) {
        new EventDemo1().init();
    }
}
