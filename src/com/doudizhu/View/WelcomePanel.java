package com.doudizhu.View;

import com.doudizhu.Controller.Controller;
import com.doudizhu.Controller.GameActionLis;
import com.doudizhu.Controller.MouseRightLi;

import javax.swing.*;
import java.awt.*;

/**
 * @Author Lucky友人a
 * @Date 2022/8/30 -14:43
 */

public class WelcomePanel extends JPanel {
    public JButton startGame;
    public JButton gameIntroduce;
    public JButton gameExit;
    public Controller controller;

    public WelcomePanel(Controller controller) {
        this.controller = controller;
        Font font = new Font("黑体", 1, 15);// 1是加粗
        setLayout(null);
        startGame = new JButton(new ImageIcon("D:/workspace/JAVAworkspace/JAVAworkspace/resources/img/btnWelcome.png"));
        gameIntroduce = new JButton(new ImageIcon("D:\\workspace\\JAVAworkspace\\JAVAworkspace\\resources\\img/btnWelcome2.png"));
        gameExit = new JButton(new ImageIcon("D:\\workspace\\JAVAworkspace\\JAVAworkspace\\resources\\img/btnWelcome3.png"));

        addMouseListener(new MouseRightLi());
        add(startGame);
        add(gameIntroduce);
        add(gameExit);
        startGame.setFont(font);
        gameIntroduce.setFont(font);//游戏介绍加字体
        gameExit.setFont(font);

        startGame.setBounds(490, 355, 136, 70);
        gameIntroduce.setBounds(490,440 , 136, 70);
        gameExit.setBounds(490, 525, 136, 70);
        GameActionLis gameActionLis = new GameActionLis(controller);
        gameIntroduce.addActionListener(gameActionLis);
        gameIntroduce.setActionCommand("gameIntroduce");
        gameExit.addActionListener(gameActionLis);
        gameExit.setActionCommand("gameExit");
        startGame.addActionListener(gameActionLis);
        startGame.setActionCommand("goGame");
    }


    @Override
    protected void paintComponent(Graphics g) {//这个没s
        super.paintComponent(g);//实现图片绘制的方法
        Image bgImg = new ImageIcon("resources/img/welcome.png").getImage();//绘制背景图片
        g.drawImage(bgImg, 0, 0, 1100, 700, null);//第五参数观察者

    }
}
