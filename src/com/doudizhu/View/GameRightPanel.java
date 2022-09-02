package com.doudizhu.View;

import com.doudizhu.Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * @Author Lucky友人a
 * @Date 2022/8/31 -22:51
 */

public class GameRightPanel extends JPanel {
    public Controller controller;
    public JLabel jlPlayer2;
    public GameRightPanel(Controller controller) {
        this.controller = controller;
        Font font = new Font("黑体", 1, 15);// 1是加粗
        setLayout(null);
        setOpaque(false);//允许底层像素显示
//        setBackground(null);//让背景没有颜色
        setPreferredSize(new Dimension(120, 0));// 首选大小，右边框的宽

        jlPlayer2 = new JLabel(controller.playerC.playerName);
        jlPlayer2.setBounds(55,10,50,50);
        add(jlPlayer2);
        jlPlayer2.setFont(font);

    }
    @Override
    protected void paintComponent(Graphics g) {//这个没s
        super.paintComponent(g);//实现图片绘制的方法
        Image bgImg1 = new ImageIcon("resources/img/player/girl_farmer_smile.png").getImage();//绘制背景图片
        g.drawImage(bgImg1, 20, 52, 97, 97, null);//第五参数观察者
        for (int i=0;i<controller.playerC.frontView.size();i++) {
            Image bgImg = new ImageIcon(controller.playerC.frontView.get(i).frontView).getImage();//绘制背景图片
            g.drawImage(bgImg, 40, 150+12*i, 70, 101, null);//第五参数观察者
        }

    }
}
