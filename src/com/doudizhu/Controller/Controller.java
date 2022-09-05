package com.doudizhu.Controller;

import com.doudizhu.Model.*;
import com.doudizhu.View.UI;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Controller {
    public Object[] gameExit = {"确定", "取消"}; //退出游戏的弹框
    public Object[] gameIntroduce = {"退出"};//游戏介绍的弹框
    public Object[] zeroSure = {"清零", "确定"}; //游戏菜单项里的清0
    public Object[] relevantGame = {"确定"}; //游戏菜单项里的关于
    public Object[] playerGaming = {"退出并开始新游戏", "继续游戏"}; //游戏菜单项里的关于

    public MouseRightLi mouseRightLi;//鼠标右击监听
    public BgMusic bgMusic;
    public ArrayList<PaperCard> paperCards;
    public boolean isStart = false;//在这加一个布尔值来判断游戏是否开始
    public DealCardsTimer gameTimer;
    public Player playerA;
    public PlayerAi1 playerB;
    public PlayerAi2 playerC;
    public ArrayList<PaperCard> surplusCards;//剩余卡的列表
    public PlayerFather nowPlayer;
    public int[] callAry = {0, 3, 2, 1}; //用来随机数那减去底分
    public CallScoreTimer callScoreTimer;

    public PlayerCallTimer playerTimer;
    public int baseScore;

    public Controller() {
        mouseRightLi = new MouseRightLi();//鼠标右击监听
        paperCards = new ArrayList<>();
        surplusCards = new ArrayList<>();
        init(); //调用方法。初始化牌，并打乱，把new出来的类给卡牌列表
//        System.out.println(paperCards.size());//打印卡牌数量
        playerA = new Player(this, "玩家A", 1111);
        playerB = new PlayerAi1(this, "玩家B", 1000);
        playerC = new PlayerAi2(this, "玩家C", 1000);
        gameTimer = new DealCardsTimer(this);
        playerTimer = new PlayerCallTimer(this);
        callScoreTimer = new CallScoreTimer(this);
//        bgMusic = new BgMusic(this);
//        bgMusic.start();//启动新的线程，无限循环bgm
    }

    public void init() {  //初始化牌，并打乱，把new出来的类给卡牌列表
        for (int i = 3; i <= 15; i++) {
            for (int j = 1; j <= 4; j++) {
                PaperCard paperCard = new PaperCard(j, i, "resources/img/cards/" + j + "-" + i + ".png", "resources/img/cover.png", false);
                paperCards.add(paperCard);
            }
        }
        paperCards.add(new PaperCard(0, 16, "resources/img/cards/16.png", "resources/img/cover.png", false));//小王
        paperCards.add(new PaperCard(0, 17, "resources/img/cards/17.png", "resources/img/cover.png", false));//大王
        Collections.shuffle(paperCards);//打乱牌
    }

    public void firstGetCard() {
        Random random = new Random();
        int r = random.nextInt(3);//范围0，1，2
        System.out.println("第一个得到卡的是" + r);
        switch (r) {
            case 0:
                nowPlayer = playerA;
                break;
            case 1:
                nowPlayer = playerB;
                break;
            case 2:
                nowPlayer = playerC;
                break;
        }

    }

    public void lunPlayer() {

        if (nowPlayer == playerA) {//简单判断来实现下家是谁
            nowPlayer = playerC;
        } else if (nowPlayer == playerC) {
            nowPlayer = playerB;
        } else {
            nowPlayer = playerA;
        }
    }

    public void thanSize() {
        if (playerA.callScore > playerB.callScore) {
            if (playerA.callScore > playerC.callScore) {
                nowPlayer = playerA;
            } else {
                nowPlayer = playerC;
            }
            diZhuPai();
        } else if (playerB.callScore > playerC.callScore) {
            nowPlayer = playerB;
            diZhuPai();
        } else if (playerA.callScore == playerB.callScore && playerA.callScore == playerC.callScore) {
            System.out.println("都不要地主，重开了");
            System.out.println("重新开始新的发牌");
            System.out.println("----------------");
            paperCards.clear();
            surplusCards.clear();
            playerA.frontView.clear();
            playerB.frontView.clear();
            playerC.frontView.clear();
            init();
            UI.gameFrame.repaint();
            isStart = false;//游戏结束
            UI.gameFrame.gamePanel.btnSco1.setVisible(false);
            UI.gameFrame.gamePanel.btnSco2.setVisible(false);
            UI.gameFrame.gamePanel.btnSco3.setVisible(false);
            UI.gameFrame.gamePanel.btnSco0.setVisible(false);
            gameTimer.myTimer.stop();
            playerTimer.playerTimer.stop();
            callScoreTimer.callTimer.stop();
            callScoreTimer.sum = 1;
            playerTimer.sum1 = 1;
            baseScore = 0;
            // 弹框提示是否再次发牌
            int a = JOptionPane.showOptionDialog(UI.welcomeFrame, "是否再次发牌？",
                    "重新游戏", JOptionPane.YES_NO_OPTION, -1, null, gameExit, gameExit[0]);
            if (a == 0) {
                System.out.println("重新开始新的发牌");
                System.out.println("----------------");

                firstGetCard();//确定谁是第一个拿牌的
                gameTimer.myTimer.start();//定时器启动
                isStart = true;//游戏开始

            }


        } else {
            nowPlayer = playerC;
            diZhuPai();
        }
    }


    public void diZhuPai() {

        if (nowPlayer == playerA) {

            playerA.frontView.add(surplusCards.get(0));
            playerA.frontView.add(surplusCards.get(1));
            playerA.frontView.add(surplusCards.get(2));
            playerA.sort();
            UI.gameFrame.gamePanel.gameSouthPanel.repaint();
            playerA.isDiZhu = true;
            UI.gameFrame.gamePanel.gameSouthPanel.repaint();
        } else if (nowPlayer == playerB) {

            playerB.frontView.add(surplusCards.get(0));
            playerB.frontView.add(surplusCards.get(1));
            playerB.frontView.add(surplusCards.get(2));
            playerB.sort();
            UI.gameFrame.gamePanel.gameLeftPanel.repaint();
            playerB.isDiZhu = true;
            UI.gameFrame.gamePanel.gameLeftPanel.repaint();
        } else if (nowPlayer == playerC) {

            playerC.frontView.add(surplusCards.get(0));
            playerC.frontView.add(surplusCards.get(1));
            playerC.frontView.add(surplusCards.get(2));
            playerC.sort();
            UI.gameFrame.gamePanel.gameRightPanel.repaint();
            playerC.isDiZhu = true;
            UI.gameFrame.gamePanel.gameRightPanel.repaint();
        }
        System.out.println("地主是" + nowPlayer.playerName + ",叫了" + nowPlayer.callScore + "分");
    }


}
