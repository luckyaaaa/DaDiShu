package com.doudizhu.View;

import com.doudizhu.Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * @Author Lucky友人a
 * @Date 2022/8/31 -22:51
 */

public class GameLeftPanel extends JPanel {
    public Controller controller;
    public JLabel jlPlayer1;

    public GameLeftPanel(Controller controller) {
        this.controller = controller;
        Font font = new Font("黑体", 1, 15);// 1是加粗
        setLayout(null);//自由布局
        setOpaque(false);//允许底层像素显示
        setPreferredSize(new Dimension(120, 0));// 首选大小，右边框的宽
        jlPlayer1 = new JLabel(controller.playerB.playerName);
        jlPlayer1.setBounds(15, 10, 50, 50);
        add(jlPlayer1);//添加玩家名字
        jlPlayer1.setFont(font);//设置字体
    }

    @Override
    protected void paintComponent(Graphics g) {//这个没s
        super.paintComponent(g);//实现图片绘制的方法
        Image bgImg1 = new ImageIcon("resources/img/player/playerB.png").getImage();//绘制背景图片
        g.drawImage(bgImg1, 5, 52, 90,90, null);//第五参数观察者
        for (int i = 0; i < controller.playerB.frontView.size(); i++) {//玩家B里的手牌列表的长度
            Image bgImg = new ImageIcon(controller.playerB.frontView.get(i).frontView).getImage();//绘制背景图片


            if (controller.playerB.isDiZhu && (controller.playerB.frontView.get(i).frontView == controller.surplusCards.get(0).frontView || controller.playerB.frontView.get(i).frontView == controller.surplusCards.get(1).frontView || controller.playerB.frontView.get(i).frontView == controller.surplusCards.get(2).frontView)) {
                g.drawImage(bgImg, 40, 150 + 12 * i, 70, 101, null);//第五参数观察者
            } else {
                g.drawImage(bgImg, 20, 150 + 12 * i, 70, 101, null);//第五参数观察者
            }


        }
    }
}
