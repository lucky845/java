package com.basic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName: JFileChooserDemo5
 * @Description:
 * @Date: 2021/9/23 18:31
 * @Author lichuang
 * @Since JDK 1.8
 */
public class JFileChooserDemo5 {

    private JFrame jf = new JFrame("测试JFileChooser");

    // 创建文件打开对话框
    private JFileChooser chooser = new JFileChooser(".");

    // 创建菜单条
    private JMenuBar jmb = new JMenuBar();

    // 创建菜单
    private JMenu jMenu = new JMenu("文件");

    // 创建菜单项
    private JMenuItem open = new JMenuItem(new AbstractAction("打开") {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooser.showOpenDialog(jf);
            // 获取用户打开文件路径
            File imageFile = chooser.getSelectedFile();
            try {
                image = ImageIO.read(imageFile);
                drawArea.repaint();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    });

    // 创建菜单项
    private JMenuItem save = new JMenuItem(new AbstractAction("另存为") {
        @Override
        public void actionPerformed(ActionEvent e) {
           chooser.showSaveDialog(jf);
            // 获取用户保存文件路径
            File dir = chooser.getSelectedFile();
            try {
                ImageIO.write(image,"jpeg",dir);
                drawArea.repaint();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    });

    // 用来记录打开的图片
    private BufferedImage image;

    // 显示图片
    // swing提供的组件都使用了图片缓冲区
    private class MyCanvas extends JPanel{
        @Override
        public void paint(Graphics g) {
            // 把图片绘制到组件上即可
            if(image != null){
                g.drawImage(image,0,0,null);
            }
        }
    }

    private JPanel drawArea = new MyCanvas();


    public void init(){

        // 设置图片区域大小
        drawArea.setPreferredSize(new Dimension(750,500));
        jf.add(drawArea);

        // 组装并设置菜单条
        jMenu.add(open);
        jMenu.add(save);
        jmb.add(jMenu);
        jf.setJMenuBar(jmb);


        // 关闭事件和设置最佳大小以及设置可见
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JFileChooserDemo5().init();
    }
}
