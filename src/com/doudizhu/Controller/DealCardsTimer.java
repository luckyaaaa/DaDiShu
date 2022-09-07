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
    public int delay = 10; //时间间隔  单位是毫秒

    public DealCardsTimer(Controller controller) {
        this.controller = controller;
        myTimer = new Timer(delay, actLis);//仅仅只是创建了定时器,需要启动才行
    }

    public ActionListener actLis = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { //定时器启动
            //通过点击发牌，监听器那边先调用第一个得到牌的玩家赋值给nowPlayer
            //再调用下家的方法


            if (controller.paperCards.size() > 3) {
                controller.nowPlayer.frontView.add(controller.paperCards.get(0));//将纸牌列表里的牌类给当前玩家列表添加
                controller.nowPlayer.sort();//调用当前玩家类里面的卡牌排序方法

                controller.paperCards.remove(0);//移除第一个数据
                controller.lunPlayer();

                UI.gameFrame.repaint();//重绘

            } else if (controller.paperCards.size() > 0) {
                controller.surplusCards.add(controller.paperCards.get(0));
                controller.paperCards.get(0).cardChoice=true;
                controller.paperCards.remove(0);//移除第一个数据
            } else {
                myTimer.stop();//定时器结束
                System.out.println("发牌定时器结束");


                controller.callScoreTimer.callTimer.start();
            }

        }
    };
}
