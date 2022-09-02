package com.doudizhu.Controller;


import com.doudizhu.View.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameActionLis implements ActionListener {  //因为动作监听只有一个方法所以没抽象类
    public Controller controller;

    public GameActionLis(Controller controller) {
        this.controller = controller;
    }


    @Override
    public void actionPerformed(ActionEvent e) {//e代表事件对象，用于记录和事件相关的所有事情
        switch (e.getActionCommand()) {
            case "gameIntroduce":
            case "ruleGame":
                JOptionPane.showOptionDialog(UI.welcomeFrame, "1、斗地主跟大部分玩法的牌数是一样的，都是54张。\n" +
                                "\n" +
                                "2、斗地主发牌是几张几张的发，最好留出三张底牌。\n" +
                                "\n" +
                                "3、一地主两平民，发牌前要翻过来一张牌，谁拿到了就是地主。\n" +
                                "\n" +
                                "4、而且可以拿最后的三张底牌，剩下的两个人是平民。\n" +
                                "\n" +
                                "5、打牌时不能跟单，顺子可以很长，最大的炸弹是王炸。",

                        "游戏介绍", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, controller.gameIntroduce, controller.gameIntroduce[0]);
                break;
            case "gameExit":
            case "exitGames":
                int m = JOptionPane.showOptionDialog(UI.welcomeFrame, "是否确定退出游戏？",
                        "退出游戏？", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, controller.gameExit, controller.gameExit[0]);
                if (m == 0) {//为0说明选择退出
                    System.exit(0);
                } else {//否则就返回到欢迎界面
                    return;
                }
                break;
            case "goGame":
                UI.welcomeFrame.setVisible(false);
                UI.gameFrame.setVisible(true);
                break;
            case "optionGames":
                UI.optionGamesFrame.setVisible(true);
                break;
            case "scoreGames":
                JOptionPane.showOptionDialog(UI.welcomeFrame, "                  刘备  关羽  张飞\n累计得分     0        0      0",
                        "得分", JOptionPane.YES_NO_OPTION, -1, null, controller.zeroSure, controller.zeroSure[0]);
                break;
            case "relevantGame":
                JOptionPane.showOptionDialog(UI.welcomeFrame, "这是关于界面",
                        "关于传一斗地主", JOptionPane.YES_NO_OPTION, -1, null, controller.relevantGame, controller.relevantGame[0]);
                break;
            case "dealCards":
                controller.firstGetCard();//确定谁是第一个拿牌的

                controller.gameTimer.myTimer.start();
                controller.isStart = true;//游戏开始

                break;
        }

    }
}
