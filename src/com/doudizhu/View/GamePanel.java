package com.doudizhu.View;

import com.doudizhu.Controller.Controller;
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

    public GamePanel(Controller controller) {
        this.controller = controller;
        addMouseListener(new MouseRightLi());//添加右边右键监听

        setLayout(new BorderLayout());// 设置边界布局,添加左右下的JPanel，自身自动居中
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

        for (int i = 0; i < controller.paperCards.size(); i++) {//牌的列表长度
            Image cards = new ImageIcon(controller.paperCards.get(i).reverseView).getImage();//背面牌准备来发牌
            g.drawImage(cards, 360 + i * 3, 240, 70, 101, null);
            //  g.drawImage(cards, 330+i*10, 220, 70, 101, null);//查看明牌

        }

    }
}
