package com.doudizhu.Controller;

import com.doudizhu.View.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author Lucky友人a
 * @Date 2022/9/7 -13:47
 */

public class ChuPaperTimer {
    public Timer chuPaiTimer;                      //这里是Swing里的Timer类
    public Controller controller;
    public int delay = 1000; //时间间隔  单位是毫秒
    public int sum2 = 1;

    public ChuPaperTimer(Controller controller) {
        this.controller = controller;
        chuPaiTimer = new Timer(delay, actLis);//仅仅只是创建了定时器,需要启动才行
    }

    public ActionListener actLis = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { //定时器启动
            //通过点击发牌，监听器那边先调用第一个得到牌的玩家赋值给nowPlayer
            //再调用下家的方法
            System.out.println("玩家倒计时器启动30s" + ",现在是第" + sum2 + "秒");
            controller.clickPaper();
            sum2++;
            if (sum2 == 30) {
                chuPaiTimer.stop();
            }
        }
    };
}
