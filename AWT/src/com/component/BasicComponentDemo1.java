package com.component;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: BasicComponentDemo1
 * @Description:
 * @Date: 2021/9/22 11:22
 * @Author lichuang
 * @Since JDK 1.8
 */
public class BasicComponentDemo1 {
    Frame frame = new Frame("测试BasicComponent");

    TextArea ta = new TextArea(5,20); // 多行文本框(5行20列)

    Choice colorChooser = new Choice(); // 下拉框

    CheckboxGroup cbg = new CheckboxGroup(); // 将多个组件组合为一组
    Checkbox male = new Checkbox("男",cbg,true);
    Checkbox female = new Checkbox("女",cbg,false);

    Checkbox isMarried = new Checkbox("是否已婚？"); // 单选框

    TextField tf = new TextField(50); // 单行文本框(列)

    Button ok = new Button("确认"); // 按钮

    List colorList = new List(6,true); // 表框(行，支持多选)

    public void init(){
        // 组件界面

        // 组装底部
        Box hBox1 = Box.createHorizontalBox();
        hBox1.add(tf);
        hBox1.add(ok);

        frame.add(hBox1,BorderLayout.SOUTH); // 添加底部

        // 组装选择部分
        colorChooser.add("红色");
        colorChooser.add("绿色");
        colorChooser.add("蓝色");
        Box hBox2 = Box.createHorizontalBox();
        hBox2.add(colorChooser);
        hBox2.add(male);
        hBox2.add(female);
        hBox2.add(isMarried);

        // 组装文本域和选择部分
        Box vBox = Box.createVerticalBox();
        vBox.add(ta);
        vBox.add(hBox2);

        // 组装顶部左边和列表框
        colorList.add("红色");
        colorList.add("绿色");
        colorList.add("蓝色");

        Box hBox3 = Box.createHorizontalBox();
        hBox3.add(vBox);
        hBox3.add(colorList);

        frame.add(hBox3); // 添加顶部
        // 设置最佳大小，并设置可见
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BasicComponentDemo1().init();

    }
}
