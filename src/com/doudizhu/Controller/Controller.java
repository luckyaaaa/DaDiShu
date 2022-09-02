package com.doudizhu.Controller;

import com.doudizhu.Model.PaperCard;
import com.doudizhu.Model.Player;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Controller {
    public Object[] gameExit = {"确定", "取消"}; //退出游戏的弹框
    public Object[] gameIntroduce = {"退出"};//游戏介绍的弹框
    public Object[] zeroSure = {"清零", "确定"}; //游戏菜单项里的清0
    public Object[] relevantGame = {"确定"}; //游戏菜单项里的关于
    public MouseRightLi mouseRightLi;//鼠标右击监听
    public BgMusic bgMusic;
    public ArrayList<PaperCard> paperCards;
    public boolean isStart = false;//在这加一个布尔值来判断游戏是否开始
    public DealCardsTimer gameTimer;
    public Player playerA;
    public Player playerB;
    public Player playerC;
    public ArrayList<PaperCard> surplusCards;//剩余卡的列表


    public Controller() {
        mouseRightLi = new MouseRightLi();//鼠标右击监听
        paperCards = new ArrayList<>();
        surplusCards = new ArrayList<>();
        init(); //调用方法。初始化牌，并打乱，把new出来的类给卡牌列表
//        System.out.println(paperCards.size());//打印卡牌数量

        playerA = new Player("小维", 1000, false);
        playerB = new Player("玩家B", 1000, false);
        playerC = new Player("玩家C", 1000, false);
        gameTimer = new DealCardsTimer(this);

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

    public void firstGetCard() { //谁第一个拿到牌，用这个方法
        Random random = new Random();
        int r = random.nextInt(3);
        System.out.println("r的值为" + r);
        if (r == 0) {
            playerA.nextPlayer = true;
        } else if (r == 1) {
            playerB.nextPlayer = true;
        } else {
            playerC.nextPlayer = true;
        }
    }

    public void nextPlayer() { //逆时针下家处理的方法
        if (playerA.nextPlayer) {
            playerA.nextPlayer = false;
            playerB.nextPlayer = false;
            playerC.nextPlayer = true;
        } else if (playerC.nextPlayer) {
            playerA.nextPlayer = false;
            playerB.nextPlayer = true;
            playerC.nextPlayer = false;

        } else {
            playerA.nextPlayer = true;
            playerB.nextPlayer = false;
            playerC.nextPlayer = false;
        }
    }

}
