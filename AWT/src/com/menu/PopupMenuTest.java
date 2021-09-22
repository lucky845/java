package com.menu;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @ClassName: PopupMenuTest
 * @Description:
 * @Date: 2021/9/22 16:55
 * @Author lichuang
 * @Since JDK 1.8
 */
public class PopupMenuTest {
    // 1.创建PopubMenu菜单组件；
    // 2.创建多个MenuItem菜单项，并添加到PopupMenu中；
    // 3.将PopupMenu添加到目标组件中；
    // 4.为需要右击出现PopubMenu菜单的组件，注册鼠标监听事件，当监听到用户释放右键时，弹出菜单。
    private Frame frame = new Frame("测试PopupMenu");

    // 创建PopubMenu菜单
    private PopupMenu popupMenu = new PopupMenu();

    //创建菜单条
    private MenuItem commentItem = new MenuItem("注释");
    private MenuItem cancelItem = new MenuItem("取消注释");
    private MenuItem copyItem = new MenuItem("复制");
    private MenuItem pasteItem = new MenuItem("保存");

    // 创建一个文本框
    private TextArea ta = new TextArea("我爱中华！",6,40);

    // 创建一个panel容器
    private Panel panel = new Panel();

    public void init(){

        // 将菜单项添加到菜单
        popupMenu.add(commentItem);
        popupMenu.add(cancelItem);
        popupMenu.add(copyItem);
        popupMenu.add(pasteItem);

        // 设置panel容器大小
        panel.setPreferredSize(new Dimension(300,100));

        // 将popupMenu容器加入panel中
        panel.add(popupMenu);

        // 为panel注册鼠标事件
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean flag = e.isPopupTrigger();
                //判断当前鼠标操作是不是触发PopupMenu的操作
                if(flag){
                    //让PopupMenu显示在panel上，并且跟随鼠标事件发生的地方显示
                    popupMenu.show(panel,e.getX(),e.getY());
                }
            }
        });

        //把ta添加到frame中间区域中
        frame.add(ta);

        //把panel添加到frame底部
        frame.add(panel,BorderLayout.SOUTH);

        // 设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PopupMenuTest().init();
    }

}
