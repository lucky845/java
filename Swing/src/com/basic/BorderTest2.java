package com.basic;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * @ClassName: BorderTest2
 * @Description:
 * @Date: 2021/9/23 16:01
 * @Author lichuang
 * @Since JDK 1.8
 */
public class BorderTest2 {

    JFrame jf = new JFrame("测试窗口边框");



    public void init(){
        // 组装视图
        // 1.JFrame的布局修改为GridLayout（网格布局）
        jf.setLayout(new GridLayout(2,4));

        // 2.向网格中填充不同的JPanel组件,并设置不同的边框
        //创建凸起的斜边框，分别设置四条边的颜色
        Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED,Color.GREEN,Color.BLUE,Color.GRAY);
        jf.add(getPanelWithBorder(bb,"BevelBorder"));

        //创建LineBorder
        Border lb = BorderFactory.createLineBorder(Color.ORANGE, 10);
        jf.add(getPanelWithBorder(lb,"LineBorder"));

        //创建EmptyBorder，会在组件的四周留白
        Border eb = BorderFactory.createEmptyBorder(20, 5, 10, 30);
        jf.add(getPanelWithBorder(eb,"EmptyBorder"));

        //创建EtchedBorder，
        Border etb = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.RED, Color.GREEN);
        jf.add(getPanelWithBorder(etb,"EtchedBorder"));

        //创建TitledBorder,为原有的Border添加标题
        TitledBorder tb = new TitledBorder(lb,"测试标题", TitledBorder.LEFT,TitledBorder.BOTTOM,new Font("StSong",Font.BOLD,18),Color.BLUE);
        jf.add(getPanelWithBorder(tb,"TitledBorder"));

        //直接创建MatteBorder，它是EmptyBorder的子类，EmptyBorder是留白，而MatteBorder可以给留空的区域填充颜色
        MatteBorder mb = new MatteBorder(20,5,10,30,Color.GREEN);
        jf.add(getPanelWithBorder(mb,"MatteBorder"));

        //直接创创建CompoundBorder，将两个边框组合成新边框
        CompoundBorder cb = new CompoundBorder(new LineBorder(Color.RED,8),tb);
        jf.add(getPanelWithBorder(cb,"CompoundBorder"));

        // 3.设置窗口最佳大小并可见,处理关闭事件
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出按钮事件
        jf.pack();
        jf.setVisible(true);

    }

    /**
     * 用来设置边框
     * @param border 边框样式
     * @param content 需要显示的文字
     * @return JPanel对象
     */
    public JPanel getPanelWithBorder(Border border, String content){

        JPanel jPanel = new JPanel();

        jPanel.add(new JLabel(content));
        jPanel.setBorder(border);

        return jPanel;

    }

    public static void main(String[] args) {
        new BorderTest2().init();
    }
}
