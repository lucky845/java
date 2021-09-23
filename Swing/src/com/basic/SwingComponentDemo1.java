package com.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: SwingComponentDemo1
 * @Description:
 * @Date: 2021/9/23 14:16
 * @Author lichuang
 * @Since JDK 1.8
 */
public class SwingComponentDemo1 {

    JFrame jf = new JFrame("测试swing基本组件");

    // 声明菜单相关的组件
    JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("文件");
    JMenu editMenu = new JMenu("编辑");

    JMenuItem auto = new JMenuItem("自动换行");
    JMenuItem copy = new JMenuItem("复制",new ImageIcon("swing\\img\\component\\copy.png"));
    JMenuItem paste = new JMenuItem("粘贴",new ImageIcon("swing\\img\\component\\paste.png"));

    JMenu formatMenu = new JMenu("格式");
    JMenuItem comment = new JMenuItem("注释");
    JMenuItem cancelComment = new JMenuItem("取消注释");

    // 声明文本域
    JTextArea ta = new JTextArea(8,20);

    String[] color = {"红色","绿色","蓝色"};
    // 声明颜色选择框
    JList<String> colorList = new JList<>(color);

    // 声明选择相关组件
    JComboBox<String> colorSelect = new JComboBox<>();

    // 声明单选框
    ButtonGroup bg = new ButtonGroup();
    JRadioButton male = new JRadioButton("男",false);
    JRadioButton female = new JRadioButton("女",true);

    // 声明复选框
    JCheckBox isMarried = new JCheckBox("是否已婚？");

    // 声明底部
    // 声明文本框
    JTextField tf = new JTextField(40);

    // 声明按钮
    JButton ok = new JButton("确定",new ImageIcon("swing\\img\\component\\ok.png"));

    // 声明右键菜单
    JPopupMenu jPopupMenu = new JPopupMenu();

    ButtonGroup poupButtonBg = new ButtonGroup();
    // 右键菜单项
    JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal 风格",true);
    JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus 风格",true);
    JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows 风格",true);
    JRadioButtonMenuItem windowsClassicItem = new JRadioButtonMenuItem("Windows 经典风格",true);
    JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif 风格",true);


    // 初始化界面
    public void init(){
        // 组装视图

        // 组装底部
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(tf);
        bottomPanel.add(ok);

        jf.add(bottomPanel, BorderLayout.SOUTH);

        // 组装选择相关的组件
        JPanel selectPanel = new JPanel();

        colorSelect.addItem("红色");
        colorSelect.addItem("绿色");
        colorSelect.addItem("蓝色");

        selectPanel.add(colorSelect); // 颜色选择框

        bg.add(male);
        bg.add(female);

        selectPanel.add(male); // 男
        selectPanel.add(female); // 女

        selectPanel.add(isMarried); // 是否已婚

        // 组装文本域和选择相关组件
        Box topLeft = Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(selectPanel);

        // 组装顶部
        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);

        jf.add(top);

        // 组装顶部菜单
        formatMenu.add(comment);
        formatMenu.add(cancelComment);

        editMenu.add(auto); // 添加自动换行
        editMenu.addSeparator(); // 添加分割线
        editMenu.add(copy); // 复制
        editMenu.add(paste); // 粘贴
        editMenu.addSeparator(); // 添加分割线
        editMenu.add(formatMenu); // 格式

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        jf.setJMenuBar(menuBar);

        // 组装右键菜单
        poupButtonBg.add(metalItem);
        poupButtonBg.add(nimbusItem);
        poupButtonBg.add(windowsItem);
        poupButtonBg.add(windowsClassicItem);
        poupButtonBg.add(motifItem);

        //给5个风格菜单创建事件监听器
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当前选择的是哪一个
                String actionCommand = e.getActionCommand();
                try {
                    changeFlavor(actionCommand);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        //为5个风格菜单项注册监听器
        metalItem.addActionListener(listener);
        nimbusItem.addActionListener(listener);
        windowsItem.addActionListener(listener);
        windowsClassicItem.addActionListener(listener);
        motifItem.addActionListener(listener);

        jPopupMenu.add(metalItem);
        jPopupMenu.add(nimbusItem);
        jPopupMenu.add(windowsItem);
        jPopupMenu.add(windowsClassicItem);
        jPopupMenu.add(motifItem);

        //调用ta组件的setComponentPopupMenu即可设置右键菜单，无需使用事件
        ta.setComponentPopupMenu(jPopupMenu);

        // 设置关闭窗口时退出程序
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置jFrame最佳大小并可见
        jf.pack();
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new SwingComponentDemo1().init();
    }

    //定义一个方法，用于改变界面风格
    private void changeFlavor(String command) throws Exception{
        switch (command){
            case "Metal 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case "Nimbus 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                break;
            case "Windows 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case "Windows 经典风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                break;
            case "Motif 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                break;
        }

        //更新f窗口内顶级容器以及所有组件的UI
        SwingUtilities.updateComponentTreeUI(jf.getContentPane());
        //更新mb菜单条及每部所有组件UI
        SwingUtilities.updateComponentTreeUI(menuBar);
        //更新右键菜单及内部所有菜单项的UI
        SwingUtilities.updateComponentTreeUI(jPopupMenu);
    }

}
