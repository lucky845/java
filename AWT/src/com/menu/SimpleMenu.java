package com.menu;

import java.awt.*;
import java.awt.event.*;

import static java.awt.event.KeyEvent.VK_Q;

/**
 * @ClassName: SimpleMenu
 * @Description:
 * @Date: 2021/9/22 14:30
 * @Author lichuang
 * @Since JDK 1.8
 */
public class SimpleMenu {

    //创建窗口
    private Frame frame = new Frame("这里测试菜单相关组件");
    //创建菜单条组件
    private MenuBar menuBar = new MenuBar();
    //创建文件菜单组件
    private Menu fileMenu = new Menu("文件");
    //创建编辑菜单组件
    private Menu editMenu = new Menu("编辑");
    //创建新建菜单项
    private MenuItem newItem = new MenuItem("新建");
    //创建保存菜单项
    private MenuItem saveItem = new MenuItem("保存");
    //创建退出菜单项
    private MenuItem exitItem = new MenuItem("退出");

    //创建自动换行选择框菜单项
    private CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");

    //创建复制菜单项
    private MenuItem copyItem = new MenuItem("复制");

    //创建粘贴菜单项
    private MenuItem pasteItem = new MenuItem("粘贴");

    //创建格式菜单
    private Menu formatMenu = new Menu("格式");

    //创建注释菜单项
    private MenuItem commentItem = new MenuItem("注释",new MenuShortcut(KeyEvent.VK_Q,true));
    //创建取消注释菜单项
    private MenuItem cancelItem = new MenuItem("取消注释");

    //创建一个文本域
    private TextArea ta = new TextArea(6, 40);

    public void init(){
        // 组装视图

        //定义菜单事件监听器
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                ta.append("单击“"+command+"”菜单\n");
                if (command.equals("退出")){
                    System.exit(0);
                }
            }
        };

        //为注释菜单项和退出菜单项注册监听器
        commentItem.addActionListener(listener);
        exitItem.addActionListener(listener);

        //为文件菜单fileMenu添加菜单项
        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        //为编辑菜单editMenu添加菜单项
        editMenu.add(autoWrap);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        //为格式化菜单formatMenu添加菜单项
        formatMenu.add(commentItem);
        formatMenu.add(cancelItem);

        //将格式化菜单添加到编辑菜单中，作为二级菜单
        editMenu.add(new MenuItem("-"));
        editMenu.add(formatMenu);


        //将文件菜单和编辑菜单添加到菜单条中
        menuBar.add(fileMenu);
        menuBar.add(editMenu);


        //把菜单条设置到frame窗口上
        frame.setMenuBar(menuBar);

        //把文本域添加到frame中
        frame.add(ta);

        //设置frame最佳大小并可见
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
        new SimpleMenu().init();
    }

}
