package com.doudizhu.Controller;

import com.doudizhu.View.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author Lucky友人a
 * @Date 2022/9/4 -11:50
 */

public class PlayerCallTimer {
    public Timer playerTimer;                          //这里是Swing里的Timer类
    public Controller controller;
    public int delay = 1000; //时间间隔  单位是毫秒
    public int sum1=1;

    public PlayerCallTimer(Controller controller) {
        this.controller = controller;
        playerTimer = new Timer(delay, actLis);//仅仅只是创建了定时器,需要启动才行
    }

    public ActionListener actLis = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { //定时器启动
            //通过点击发牌，监听器那边先调用第一个得到牌的玩家赋值给nowPlayer
            //再调用下家的方法
            System.out.println("玩家计时器启动30s"+",现在是第"+sum1+"秒");
            sum1++;


            if (sum1 == 30) {
                System.out.println("玩家计时器时间到了，自动选0分");
                System.out.println("玩家A不叫");
                controller.nowPlayer.callScore = controller.callAry[0];
                controller.baseScore=0;
                UI.gameFrame.gamePanel.btnSco1.setVisible(false);
                UI.gameFrame.gamePanel.btnSco2.setVisible(false);
                UI.gameFrame.gamePanel.btnSco3.setVisible(false);
                UI.gameFrame.gamePanel.btnSco0.setVisible(false);
                controller.callScoreTimer.sum++;
                controller.lunPlayer();//换下一个叫
                playerTimer.stop();

                if (controller.callScoreTimer.sum > 3) {
                    controller.thanSize();
                    System.out.println("叫分计时器结束");
                    controller.callScoreTimer.callTimer.stop();//停下计时器
                }

            }

        }
    };
}
