package com.draw;

import com.menu.SimpleMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName: SimpleDraw1
 * @Description:
 * @Date: 2021/9/22 17:29
 * @Author lichuang
 * @Since JDK 1.8
 */
public class SimpleDraw1 {

    private final String RECT_SHAPE="rect";
    private final String OVAL_SHAPE="oval";

    private Frame frame = new Frame("测试绘图");

    private Button drawRectBtn = new Button("绘制矩形");
    private Button drawOvalBtn = new Button("绘制椭圆");

    //定义一个变量，用来保存当前用户需要绘制什么样的图形
    private String shape="";

    // 自定义类，继承Canvas类，重写paint(Graphics g)方法完成画图
    private class MyCanvas extends Canvas{

        @Override
        public void paint(Graphics g) {
            // 绘制不同的图形
            if(shape.equals(RECT_SHAPE)){ // 绘制矩形
                g.setColor(Color.black);
                g.drawRect(50,50,150,100);
            }else if(shape.equals(OVAL_SHAPE)){ // 绘制椭圆
                g.setColor(Color.red);
                g.drawOval(50,50,150,100);
            }
        }
    }

    // 创建自定义画布对象
    private MyCanvas drawArea = new MyCanvas();

    public void init(){

        // 组装视图
        // 绑定点击事件
        drawRectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 修改shape为rect
                shape = RECT_SHAPE;
                drawArea.repaint();
            }
        });
        drawOvalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 修改shape为oval
                shape = OVAL_SHAPE;
                drawArea.repaint();
            }
        });

        //定义一个Panel，装载两个按钮
        Panel p = new Panel();
        p.add(drawRectBtn);
        p.add(drawOvalBtn);

        //把panel添加到frame底部
        frame.add(p,BorderLayout.SOUTH);

        //设置画布的大小
        drawArea.setPreferredSize(new Dimension(300,200));

        //把画布添加到frame中
        frame.add(drawArea);

        // 设置最佳大小并可见
        frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new SimpleDraw1().init();
    }

}
