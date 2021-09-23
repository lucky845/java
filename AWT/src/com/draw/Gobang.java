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

public class Gobang {

    //定义三个BufferedImage，分别代表棋盘图、黑子图、白子图
    private BufferedImage table;
    private BufferedImage black;
    private BufferedImage white;

    //定义一个BufferedImage，代表当鼠标移动时将要下子的选择框
    private BufferedImage selected;

    //定义棋盘的宽高，这里的定义尺寸和给定的board.jpg图片的尺寸一致因为棋盘背景是通过图片加载的
    private final int TABLE_WIDTH = 535;
    private final int TABLE_HEIGHT = 536;

    //定义棋盘中，每行和每列可下子的数目，这个数目跟给定的board.jpg中的数目是一致的，都为15
    private final int  BOARD_SIZE = 15;

    //定义每个棋子所占棋盘总宽度的大小比率；每个棋子所占宽度 535/15=35
    private final int RATE = TABLE_WIDTH/BOARD_SIZE;

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
    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];//如果存储0，代表没有棋子，如果存储1，代表黑棋，如果存储2，代表白棋

    //定义五子棋游戏窗口
    private JFrame f = new JFrame("五子棋游戏");

    //定义五子棋游戏棋盘对应的Canvas组件
    private class ChessBoard extends JPanel{
        //重写paint方法，实现绘画
        @Override
        public void paint(Graphics g) {
            //绘制五子棋棋盘
            g.drawImage(table,0,0,null);
            //绘制选中点的红框
            if (selectX>0 && selectY>0){
                g.drawImage(selected,selectX*RATE+X_OFFSET,selectY*RATE+Y_OFFSET,null);
            }

            //遍历数组，绘制棋子
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    //绘制黑棋

                    if (board[i][j]==1){
                        g.drawImage(black,i*RATE+X_OFFSET,j*RATE+Y_OFFSET,null);
                    }

                    //绘制白棋
                    if (board[i][j]==2){
                        g.drawImage(white,i*RATE+X_OFFSET,j*RATE+Y_OFFSET,null);
                    }
                }
            }
        }
    }

    private ChessBoard chessBoard = new ChessBoard();

    //定义变量，记录当前选中的坐标点对应的boad数组中对应的棋子索引；
    private int selectX = -1;
    private int selectY = -1;

    //定义一个变量，记录当前用户选择下的是白棋还是黑棋还是清除，清除：0，黑棋：1，白棋：2；
    private int chessCategory = 1;

    //定义Panel,放置点击按钮
    Panel p = new Panel();
    private Button whiteBtn = new Button("白棋");
    private Button blackBtn = new Button("黑棋");
    private Button clearBtn = new Button("悔棋");

    public void updateBtnColor(Color whiteBtnColor,Color blackBtnColor,Color clearBtnColor){
        whiteBtn.setBackground(whiteBtnColor);
        blackBtn.setBackground(blackBtnColor);
        clearBtn.setBackground(clearBtnColor);
    }

    public void init() throws Exception{

        //初始化按钮的颜色
        updateBtnColor(Color.LIGHT_GRAY,Color.GREEN,Color.LIGHT_GRAY);
        whiteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chessCategory = 2;
                updateBtnColor(Color.GREEN,Color.LIGHT_GRAY,Color.LIGHT_GRAY);
            }
        });
        blackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chessCategory=1;
                updateBtnColor(Color.LIGHT_GRAY,Color.GREEN,Color.LIGHT_GRAY);
            }
        });
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chessCategory=0;
                updateBtnColor(Color.LIGHT_GRAY,Color.LIGHT_GRAY,Color.GREEN);
            }
        });

        p.add(whiteBtn);
        p.add(blackBtn);
        p.add(clearBtn);
        //把Panel放入到frame底部
        f.add(p,BorderLayout.SOUTH);


        //初始化黑棋，白棋，棋盘,选中框
        table = ImageIO.read(new File("AWT/img/board.jpg"));
        black = ImageIO.read(new File("AWT/img/black.gif"));
        white = ImageIO.read(new File("AWT/img/white.gif"));
        selected = ImageIO.read(new File("AWT/img/selected.gif"));
        //初始化board数组，默认情况下，所有位置处都没有棋子
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j]=0;
            }
        }

        //设置chessBoard的最佳大小
        chessBoard.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));

        //给chessBoard注册鼠标监听器
        chessBoard.addMouseListener(new MouseAdapter() {
            //鼠标单击会触发
            @Override
            public void mouseClicked(MouseEvent e) {
                //将用户鼠标的坐标，转换成棋子的坐标
                int xPos = (e.getX()-X_OFFSET)/RATE;
                int yPos = (e.getY()-Y_OFFSET)/RATE;

                board[xPos][yPos] = chessCategory;

                //重绘chessBoard
                chessBoard.repaint();
            }

            //当鼠标退出棋盘区域后，复位选中坐标,重绘chessBoard，要保证红色选中框显示正确
            @Override
            public void mouseExited(MouseEvent e) {
                selectX=-1;
                selectY=-1;
                chessBoard.repaint();
            }
        });

        //给chessBoard注册鼠标移动监听器
        chessBoard.addMouseMotionListener(new MouseMotionAdapter() {
            //当鼠标移动时，修正selectX和selectY，重绘chessBoard，要保证红色选中框显示正确
            @Override
            public void mouseMoved(MouseEvent e) {
                //将鼠标的坐标，转换成棋子的索引
                selectX = (e.getX()-X_OFFSET)/RATE;
                selectY = (e.getY()-Y_OFFSET)/RATE;
                chessBoard.repaint();
            }
        });

        //把chessBoard添加到Frame中
        f.add(chessBoard);

        //设置frame最佳大小并可见
        f.pack();
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) throws Exception{
        new Gobang().init();
    }

}
