package com.doudizhu.Controller;


import com.doudizhu.Model.Player;
import com.doudizhu.Model.PlayerAi1;
import com.doudizhu.Model.PlayerAi2;
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

                if (controller.isStart) { //这是游戏中
                    controller.gameTimer.myTimer.stop();
                    controller.playerTimer.playerTimer.stop();
                    controller.callScoreTimer.callTimer.stop();

                    int a = JOptionPane.showOptionDialog(UI.welcomeFrame, "游戏正在继续，您希望做什么？",
                            "新游戏", JOptionPane.YES_NO_OPTION, -1, null, controller.playerGaming, controller.playerGaming[0]);
                    if (a == 0) {
                        System.out.println("重新开始新的发牌");
                        System.out.println("----------------");
                        controller.paperCards.clear();
                        controller.surplusCards.clear();
                        controller.playerA.frontView.clear();
                        controller.playerB.frontView.clear();
                        controller.playerC.frontView.clear();
                        controller.init();
                        controller.playerA.isDiZhu=false;
                        controller.playerB.isDiZhu=false;
                        controller.playerC.isDiZhu=false;
                        UI.gameFrame.gamePanel.btnSco1.setVisible(false);
                        UI.gameFrame.gamePanel.btnSco2.setVisible(false);
                        UI.gameFrame.gamePanel.btnSco3.setVisible(false);
                        UI.gameFrame.gamePanel.btnSco0.setVisible(false);
                        controller.callScoreTimer.sum = 1;
                        controller.playerTimer.sum1 = 1;
                        controller.baseScore = 0;
                        UI.gameFrame.repaint();
                        //开始新的一轮
                        controller.isStart = true;//第一轮游戏开始
                        controller.firstGetCard();//确定谁是第一个拿牌的
                        controller.gameTimer.myTimer.start();//定时器启动
//                        controller.playerTimer.playerTimer.start();
//                        controller.callScoreTimer.callTimer.start();
                    }else {
                        controller.gameTimer.myTimer.start();//定时器启动
                    }
                } else {                    controller.isStart = true;//第一轮游戏开始
                    controller.firstGetCard();//确定谁是第一个拿牌的
                    controller.gameTimer.myTimer.start();//定时器启动
                }

//                controller.playerTimer.playerTimer.start();
//                controller.callScoreTimer.callTimer.start();

                break;
            case "1分":
                System.out.println("玩家A叫了1分");
                controller.nowPlayer.callScore = controller.callAry[3];
                UI.gameFrame.gamePanel.btnSco1.setVisible(false);
                UI.gameFrame.gamePanel.btnSco2.setVisible(false);
                UI.gameFrame.gamePanel.btnSco3.setVisible(false);
                UI.gameFrame.gamePanel.btnSco0.setVisible(false);
                controller.playerTimer.playerTimer.stop();
                controller.lunPlayer();//换下一个叫
                controller.callScoreTimer.sum++;
                controller.callScoreTimer.callTimer.start();
                controller.baseScore = 1;
                if (controller.callScoreTimer.sum > 3) {
                    controller.thanSize();
                    System.out.println("叫分计时器结束");
                    controller.callScoreTimer.callTimer.stop();//停下计时器
                }
                break;
            case "2分":
                System.out.println("玩家A叫了2分");
                controller.nowPlayer.callScore = controller.callAry[2];
                UI.gameFrame.gamePanel.btnSco1.setVisible(false);
                UI.gameFrame.gamePanel.btnSco2.setVisible(false);
                UI.gameFrame.gamePanel.btnSco3.setVisible(false);
                UI.gameFrame.gamePanel.btnSco0.setVisible(false);
                controller.playerTimer.playerTimer.stop();
                controller.lunPlayer();//换下一个叫
                controller.callScoreTimer.sum++;
                controller.callScoreTimer.callTimer.start();
                controller.baseScore = 2;
                if (controller.callScoreTimer.sum > 3) {
                    controller.thanSize();
                    System.out.println("叫分计时器结束");
                    controller.callScoreTimer.callTimer.stop();//停下计时器
                }
                break;
            case "3分":
                System.out.println("玩家A叫了3分");
                System.out.println(controller.nowPlayer.playerName + "是地主");
                controller.nowPlayer.callScore = controller.callAry[1];
                UI.gameFrame.gamePanel.btnSco1.setVisible(false);
                UI.gameFrame.gamePanel.btnSco2.setVisible(false);
                UI.gameFrame.gamePanel.btnSco3.setVisible(false);
                UI.gameFrame.gamePanel.btnSco0.setVisible(false);
                controller.playerA.isDiZhu = true;
                controller.diZhuPai();
                controller.playerTimer.playerTimer.stop();
                controller.callScoreTimer.callTimer.stop();
                break;
            case "不叫":
                System.out.println("玩家A不叫");
                controller.nowPlayer.callScore = controller.callAry[0];
                UI.gameFrame.gamePanel.btnSco1.setVisible(false);
                UI.gameFrame.gamePanel.btnSco2.setVisible(false);
                UI.gameFrame.gamePanel.btnSco3.setVisible(false);
                UI.gameFrame.gamePanel.btnSco0.setVisible(false);
                controller.playerTimer.playerTimer.stop();
                controller.lunPlayer();//换下一个叫
                controller.callScoreTimer.sum++;
                controller.callScoreTimer.callTimer.start();
                controller.baseScore = 0;

                if (controller.callScoreTimer.sum > 3) {
                    controller.thanSize();
                    System.out.println("叫分计时器结束");
                    controller.callScoreTimer.callTimer.stop();//停下计时器
                }
                break;
        }

    }
}
