package com.draw;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @ClassName: Gobang5
 * @Description:
 * @Date: 2021/9/22 22:45
 * @Author lichuang
 * @Since JDK 1.8
 */
public class Gobang5 {
    // 定义五子棋游戏窗口
    private JFrame frame = new JFrame("五子棋游戏");

    // 声明BufferedImage对象,分别记录四张图片
    private BufferedImage table; // 棋盘
    private BufferedImage black; // 黑棋
    private BufferedImage white; // 白棋
    private BufferedImage selected; // 选择棋子框

    //定义棋盘的宽高，这里的定义尺寸和给定的board.jpg图片的尺寸一致因为棋盘背景是通过图片加载的
    private final int TABLE_WIDTH = 535; // 宽
    private final int TABLE_HEIGHT = 536; // 高

    //定义棋盘中，每行和每列可下子的数目，这个数目跟给定的board.jpg中的数目是一致的，都为15
    private final int BOARD_SIZE = 15;

    //定义每个棋子所占棋盘总宽度的大小比率；每个棋子所占宽度 535/15=35
    private final int RATE = TABLE_WIDTH / BOARD_SIZE;

    //定义棋盘有效区域与背景图坐标之间的偏移值，x坐标右移5个像素，y坐标下移6个像素
    private final int X_OFFSET = 5;
    private final int Y_OFFSET = 6;

    /*

        定义一个二维数组充当棋盘上每个位置处的棋子；
        该数组的索引与该棋子在棋盘上的坐标需要有一个对应关系：
            例如： 索引[2][3]处的棋子，对一个的真实绘制坐标应该是：

                xpos = 2*RATE+X_OFFSET=75;
                ypos = 3*RATE+Y_OFFSET=111;

     */
    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE]; //如果存储0，代表没有棋子，如果存储2，代表黑棋，如果存储1，代表白棋

    // 声明红色选择框的坐标,该坐标其实就是二维数组的索引
    private int selected_x = -1;
    private int selected_y = -1;

    // 自定义类继承canvas，绘制图像
    private class ChessBoard extends JPanel{
        @Override
        public void paint(Graphics g) {
            //todo 绘图

            // 绘制棋盘
            g.drawImage(table,0,0,null);

            // 绘制选择框
            if (selected_x > 0 && selected_y > 0){
                g.drawImage(selected,selected_x * RATE + X_OFFSET,selected_y * RATE + Y_OFFSET,null);
            }

            //遍历数组，绘制棋子
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    // 绘制黑棋
                    if(board[i][j] == 2){
                        g.drawImage(black,i * RATE + X_OFFSET,j * RATE + Y_OFFSET,null);
                    }
                    // 绘制白棋
                    if(board[i][j] == 1){
                        g.drawImage(white,i * RATE + X_OFFSET,j * RATE + Y_OFFSET,null);
                    }
                }
            }
        }
    }

    // 创建绘图类对象
    private ChessBoard chessBoard = new ChessBoard();

    //定义一个变量，记录当前用户选择下的是白棋还是黑棋还是悔棋，悔棋：0，黑棋：2，白棋：1；
    private int board_type = 2;

    //定义Panel,放置点击按钮
    Panel p = new Panel();
    private Button whiteBtn = new Button("白棋");
    private Button blackBtn = new Button("黑棋");
    private Button deleteBtn = new Button("悔棋");

    // 修改按钮的颜色
    private void refreshBtnColor(Color whiteBtnColor,Color blackBtnColor,Color deleteBthColor){
        whiteBtn.setBackground(whiteBtnColor);
        blackBtn.setBackground(blackBtnColor);
        deleteBtn.setBackground(deleteBthColor);
    }

    public void init() throws Exception{
        // 组装按钮编写逻辑

        // 初始化按钮颜色
        refreshBtnColor(Color.gray, Color.gray, Color.gray);

        // 黑棋
        blackBtn.addActionListener(e -> {
            // 修改当前要下的棋子标记为1
            board_type = 1;
            //刷新按钮的颜色
            refreshBtnColor(Color.gray, Color.green, Color.gray);
        });
        // 白棋
        whiteBtn.addActionListener(e ->{
            // 修改要下的棋子的标记为2
            board_type = 2;
            // 刷新按钮的颜色
            refreshBtnColor(Color.green,Color.gray,Color.gray);
        });
        // 悔棋
        deleteBtn.addActionListener(e ->{
            // 修改要下的棋子的标记为0
            board_type = 0;
            // 刷新按钮的颜色
            refreshBtnColor(Color.gray,Color.gray,Color.green);
        });

        p.add(whiteBtn);
        p.add(blackBtn);
        p.add(deleteBtn);

        //把Panel放入到frame底部
        frame.add(p,BorderLayout.SOUTH);

        // 组装棋盘

        //初始化黑棋，白棋，棋盘,选中框
        table = ImageIO.read(new File("AWT\\img\\board.jpg"));
        white = ImageIO.read(new File("AWT\\img\\black.gif"));
        black = ImageIO.read(new File("AWT\\img\\white.gif"));
        selected = ImageIO.read(new File("AWT\\img\\selected.gif"));

        //初始化board数组，默认情况下，所有位置处都没有棋子
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = 0;
            }
        }

        // 处理鼠标移动
        chessBoard.addMouseMotionListener(new MouseMotionAdapter() {
            //当鼠标移动时，修正selectX和selectY，重绘chessBoard，要保证红色选中框显示正确
            @Override
            public void mouseMoved(MouseEvent e) {
                //将鼠标的坐标，转换成棋子的索引
                selected_x = (e.getX() - X_OFFSET) / RATE;
                selected_y = (e.getY() - Y_OFFSET) / RATE;
                // 重绘chessBoard
                chessBoard.repaint();
            }
        });

        // 处理鼠标点击
        chessBoard.addMouseListener(new MouseAdapter() {
            //鼠标单击会触发
            @Override
            public void mouseClicked(MouseEvent e) {
                //将用户鼠标的坐标，转换成棋子的坐标
                int xPos = (e.getX() - X_OFFSET) / RATE;
                int yPos = (e.getY() - Y_OFFSET) / RATE;

                board[xPos][yPos] = board_type;
                // 重绘chessBoard
                chessBoard.repaint();
            }

            //当鼠标退出棋盘区域后，复位选中坐标,重绘chessBoard，要保证红色选中框显示正确
            @Override
            public void mouseExited(MouseEvent e) {
                selected_x = -1;
                selected_y = -1;

                chessBoard.repaint();
            }
        });

        chessBoard.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
        // 将chessBoard加入frame中
        frame.add(chessBoard);

        // 设置最佳大小并可见
        frame.pack();
        frame.setVisible(true);
        // 为关闭窗口绑定关闭事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) throws Exception{
        new Gobang5().init();
    }

}
