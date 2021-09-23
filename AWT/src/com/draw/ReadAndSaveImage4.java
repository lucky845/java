package com.draw;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * @ClassName: ReadAndSaveImage4
 * @Description:
 * @Date: 2021/9/22 21:56
 * @Author lichuang
 * @Since JDK 1.8
 */
public class ReadAndSaveImage4 {

    private Frame frame = new Frame("图片查看器");

    private MenuBar menuBar = new MenuBar();
    private Menu menu = new Menu("文件");
    private MenuItem open = new MenuItem("打开");
    private MenuItem save = new MenuItem("另存为");

    // 声明BufferedImage对象，记录本地存取到内存的文件
    private BufferedImage image;

    private class MyCanvas extends Canvas{

        @Override
        public void paint(Graphics g) {
            if (image!=null){
                g.drawImage(image,0,0,image.getWidth(),image.getHeight(),null);
            }
        }
    }

    private MyCanvas drawArea = new MyCanvas();


    public void init() throws Exception{
        // 组装视图

        open.addActionListener(e -> {
                // 打开一个文件对话框
                FileDialog fileDialog = new FileDialog(frame,"打开图片",FileDialog.LOAD);
                fileDialog.setVisible(true);

                // 获取用户的图片路径和文件名称
                String dir = fileDialog.getDirectory();
                String fileName = fileDialog.getFile();

            try {
                image = ImageIO.read(new File(dir,fileName));
                drawArea.repaint();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        save.addActionListener(e -> {
            // 打开一个文件对话框
            FileDialog fileDialog = new FileDialog(frame,"保存图片",FileDialog.SAVE);
            fileDialog.setVisible(true);

            // 获取用户的保存路径以及文件名
            String dir = fileDialog.getDirectory();
            String fileName = fileDialog.getFile();

            try {
                ImageIO.write(image,"JPEG",new File(dir,fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        menu.add(open);
        menu.add(save);
        menuBar.add(menu);

        // 将菜单项添加到frame
        frame.setMenuBar(menuBar);
        frame.add(drawArea);

        frame.setBounds(200,200,740,508);

        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) throws Exception{
        new ReadAndSaveImage4().init();
    }
}
