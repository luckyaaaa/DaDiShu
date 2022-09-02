package com.doudizhu.View;

import com.doudizhu.Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * @Author Lucky友人a
 * @Date 2022/8/31 -22:51
 */

public class GameSouthPanel extends JPanel {
    public Controller controller;
    public JLabel jlPlayer3;
    public GameSouthPanel(Controller controller) {
        this.controller = controller;
        Font font = new Font("黑体", 1, 15);// 1是加粗
        setLayout(null);
        setOpaque(false);//允许底层像素显示
        setPreferredSize(new Dimension(0, 120));// 首选大小，右边框的宽

        jlPlayer3 = new JLabel(controller.playerA.playerName);
        jlPlayer3.setBounds(200,0,50,50);
        add(jlPlayer3);
        jlPlayer3.setFont(font);


    }
    @Override
    protected void paintComponent(Graphics g) {//这个没s
        super.paintComponent(g);//实现图片绘制的方法
        Image bgImg1 = new ImageIcon("resources/img/player/boy_farmer_smile.png").getImage();//绘制背景图片
        g.drawImage(bgImg1, 200, 0, 97, 97, null);//第五参数观察者

        for (int i=0;i<controller.playerA.frontView.size();i++) {
            Image bgImg = new ImageIcon(controller.playerA.frontView.get(i).frontView).getImage();//绘制背景图片
            g.drawImage(bgImg, 330+12*i, 0, 70, 101, null);//第五参数观察者
        }

    }
}
