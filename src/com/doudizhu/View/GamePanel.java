package com.doudizhu.View;

import com.doudizhu.Controller.Controller;
import com.doudizhu.Controller.GameActionLis;
import com.doudizhu.Controller.MouseRightLi;

import javax.swing.*;
import java.awt.*;


/**
 * @Author Lucky友人a
 * @Date 2022/8/30 -17:15
 */

public class GamePanel extends JPanel {
    public Controller controller;
    public GameRightPanel gameRightPanel;
    public GameLeftPanel gameLeftPanel;
    public GameSouthPanel gameSouthPanel;
    public JButton btnSco1;
    public JButton btnSco2;
    public JButton btnSco3;
    public JButton btnSco0;
    public JLabel plBJLabel;
    public JLabel plCJLabel;

    public JButton chuPai;
    public JButton buYao;

    public GamePanel(Controller controller) {
        this.controller = controller;
        Font font = new Font("黑体", 1, 30);// 1是加粗
        addMouseListener(new MouseRightLi());//添加右边右键监听
        btnSco1 = new JButton("1分");//给按钮添加文字
        btnSco2 = new JButton("2分");
        btnSco3 = new JButton("3分");
        btnSco0 = new JButton("不叫");
//        btnSco0 = new JButton("", new ImageIcon("resources\\img\\sucai\\0.png"));//给按钮添加图片

        plBJLabel = new JLabel();
        plCJLabel = new JLabel();
        chuPai = new JButton("出牌");
        buYao= new JButton("不要");
        GameActionLis gameActionLis1 = new GameActionLis(controller);
        chuPai.addActionListener(gameActionLis1);
        chuPai.setActionCommand("chuPai");

        btnSco1.setBounds(400, 450, 79, 45);
        btnSco2.setBounds(500, 450, 79, 45);
        btnSco3.setBounds(600, 450, 79, 45);
        btnSco0.setBounds(290, 450, 100, 45);

        plCJLabel.setBounds(900, 80, 90, 30);
        plBJLabel.setBounds(100, 80, 90, 30);

        chuPai.setBounds(360, 450, 100, 40);
        buYao.setBounds(550, 450, 100, 40);

        add(plBJLabel);
        add(plCJLabel);
        plBJLabel.setFont(font);
        plCJLabel.setFont(font);
        btnSco1.setFont(font);
        btnSco2.setFont(font);
        btnSco3.setFont(font);
        btnSco0.setFont(font);
        chuPai.setFont(font);
        buYao.setFont(font);

        add(btnSco1);
        add(btnSco2);
        add(btnSco3);
        add(btnSco0);
        add(buYao);
        add(chuPai);
        buYao.setVisible(false);
        chuPai.setVisible(false);

        btnSco1.setContentAreaFilled(false);//设置素材背景无
        btnSco1.setBorderPainted(false);//去除边框
//        btnSco1.setPressedIcon(new ImageIcon(" "));//设置点击字体会闪

        btnSco2.setContentAreaFilled(false);//设置素材背景无
        btnSco2.setBorderPainted(false);//去除边框
//        btnSco2.setPressedIcon(new ImageIcon(" "));//设置点击字体会闪

        btnSco3.setContentAreaFilled(false);//设置素材背景无
        btnSco3.setBorderPainted(false);//去除边
//        btnSco3.setPressedIcon(new ImageIcon(" "));//设置点击字体会闪

        btnSco0.setContentAreaFilled(false);//设置素材背景无
        btnSco0.setBorderPainted(false);//去除边框
//        btnSco0.setPressedIcon(new ImageIcon(" "));//设置点击字体会闪

        btnSco1.setVisible(false);//隐藏按钮
        btnSco2.setVisible(false);//隐藏按钮
        btnSco3.setVisible(false);//隐藏按钮
        btnSco0.setVisible(false);//隐藏按钮
        GameActionLis gameActionLis = new GameActionLis(controller);
        btnSco1.addActionListener(gameActionLis);
        btnSco2.addActionListener(gameActionLis);
        btnSco3.addActionListener(gameActionLis);
        btnSco0.addActionListener(gameActionLis);
        btnSco1.setActionCommand("1分");
        btnSco2.setActionCommand("2分");
        btnSco3.setActionCommand("3分");
        btnSco0.setActionCommand("不叫");

        setLayout(new BorderLayout());// 设置边界布局,添加左右下的JPanel，自身自动居中.放上面0会乱位
        gameRightPanel = new GameRightPanel(controller);
        add(gameRightPanel, BorderLayout.EAST);//东边
        gameLeftPanel = new GameLeftPanel(controller);
        add(gameLeftPanel, BorderLayout.WEST);//西
        gameSouthPanel = new GameSouthPanel(controller);
        add(gameSouthPanel, BorderLayout.SOUTH);//南

    }

    protected void paintComponent(Graphics g) {//这个没s
        super.paintComponent(g);//实现图片绘制的方法
        Image bgImg = new ImageIcon("resources/img/bg.png").getImage();//绘制背景图片
        g.drawImage(bgImg, 0, 0, 1100, 700, null);//第五参数观察者

        if (controller.paperCards.size() > 3) {
            for (int i = 0; i < controller.paperCards.size(); i++) {//牌的列表长度
                Image cards = new ImageIcon(controller.paperCards.get(i).reverseView).getImage();//背面牌准备来发牌
                g.drawImage(cards, 360 + i * 3, 240, 70, 101, null);
                //  g.drawImage(cards, 330+i*10, 220, 70, 101, null);//查看明牌

            }
        }
        if (controller.paperCards.size() <= 3) {
            for (int i = 0; i < controller.paperCards.size(); i++) {
                Image surplusBgImg = new ImageIcon(controller.paperCards.get(i).frontView).getImage();//绘制背景图片
                g.drawImage(surplusBgImg, 450 + i * 30, 0, 70, 101, null);//第五参数观察者
            }
        }
        if (controller.surplusCards.size() > 0) {
            for (int i = 0; i < controller.surplusCards.size(); i++) {//牌的列表长度
                Image cards = new ImageIcon(controller.surplusCards.get(i).frontView).getImage();//背面牌准备来发牌
                g.drawImage(cards, 360 + i * 13, 240, 70, 101, null);
                //  g.drawImage(cards, 330+i*10, 220, 70, 101, null);//查看明牌

            }
        }

    }
}
