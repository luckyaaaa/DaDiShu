package com.doudizhu.Controller;

import com.doudizhu.View.UI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author Lucky友人a
 * @Date 2022/8/31 -23:23
 */

public class DealCardsTimer {
    public Timer myTimer;                          //这里是Swing里的Timer类
    public Controller controller;
    public int delay = 100; //时间间隔  单位是毫秒

    public DealCardsTimer(Controller controller) {
        this.controller = controller;
        myTimer = new Timer(delay, actLis);//仅仅只是创建了定时器,需要启动才行
    }

    public ActionListener actLis = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { //定时器启动
            //通过点击发牌，监听器那边先调用随机下家方法，这边下家是否为true来轮着拿牌
            if (controller.playerA.nextPlayer) {//为true运行下面代码
                controller.playerA.frontView.add(controller.paperCards.get(0));//将纸牌列表里的牌类给玩家A列表添加
                UI.gameFrame.gamePanel.gameLeftPanel.repaint();//重绘左边牌
            } else if (controller.playerB.nextPlayer) {
                controller.playerB.frontView.add(controller.paperCards.get(0));//将纸牌列表里的牌类给玩家B列表添加
                UI.gameFrame.gamePanel.gameRightPanel.repaint(); //重绘右边牌
            } else if (controller.playerC.nextPlayer) {
                controller.playerC.frontView.add(controller.paperCards.get(0)); //将纸牌列表里的牌类给玩家C列表添加
                UI.gameFrame.gamePanel.gameSouthPanel.repaint();//重绘下边牌
            }
            controller.playerA.sort();//调用玩家类里面的卡牌排序方法
            controller.playerB.sort();//调用玩家类里面的卡牌排序方法
            controller.playerC.sort();//调用玩家类里面的卡牌排序方法
            controller.nextPlayer();//调用下家的处理方法
            controller.paperCards.remove(0);//异常第一个数据
            UI.gameFrame.gamePanel.repaint();//重绘牌

            if (controller.paperCards.size() == 3) {//剩下3张是地主牌
                myTimer.stop();//定时器结束
            }
        }
    };
}
