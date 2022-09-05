package com.doudizhu.Controller;

import com.doudizhu.Model.Player;
import com.doudizhu.Model.PlayerAi2;
import com.doudizhu.View.UI;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * @Author Lucky友人a
 * @Date 2022/9/2 -16:45
 */

public class CallScoreTimer {

    public Timer callTimer;                          //这里是Swing里的Timer类
    public Controller controller;
    public int delay = 1000; //时间间隔  单位是毫秒
    public int sum = 1;


    public CallScoreTimer(Controller controller) {
        this.controller = controller;
        callTimer = new Timer(delay, actLis);//仅仅只是创建了定时器,需要启动才行
    }

    public ActionListener actLis = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { //定时器启动
            System.out.println("-------------------------");
            System.out.println("叫分计时器启动第" + sum + "次");
            if (sum == 1) {
                if (controller.nowPlayer == controller.playerA) {


                    System.out.println("玩家先叫");
                    controller.playerA.callDiZhu();

                    controller.playerTimer.playerTimer.start();

                } else {
                    System.out.println(controller.nowPlayer.playerName + "先叫");
                    controller.nowPlayer.callScore = controller.callAry[controller.nowPlayer.callDiZhu()];//接收第一个人机随机到的数值放进数组得到具体的叫分
                    if (controller.nowPlayer.callScore == 3) {
                        controller.diZhuPai();
                        callTimer.stop();//停下计时器
                    } else {
                        System.out.println("第" + (sum) + "次," + controller.nowPlayer.playerName + "叫了" + controller.nowPlayer.callScore + "分");
                        controller.baseScore = controller.nowPlayer.callScore;//将数组里的值就是底分
                        sum++;
                        controller.lunPlayer();//换下一个叫
                    }

                }

            } else {
                if (controller.nowPlayer == controller.playerA) {

                    controller.playerA.callDiZhu();//绘制出分

                    System.out.println("这是玩家A这边代码，需要进行倒计时");
                    controller.playerTimer.playerTimer.start();

                } else {
                    if (controller.nowPlayer.callScore > 0) {
                        controller.baseScore = controller.nowPlayer.callScore;
                    }
                    controller.nowPlayer.callScore = controller.callAry[controller.nowPlayer.callDiZhu()];//随机到的数值放进数组得到具体的叫分

                    if (controller.nowPlayer.callScore == 0) {

                        System.out.println("第" + (sum) + "次," + controller.nowPlayer.playerName + "叫了" + controller.nowPlayer.callScore + "分");
                        sum++;
                    } else if (controller.nowPlayer.callScore == 3) {
                        controller.diZhuPai();
                        callTimer.stop();//停下计时器
                        System.out.println("第" + (sum) + "次," + controller.nowPlayer.playerName + "叫了" + controller.nowPlayer.callScore + "分");
                    } else {

                        System.out.println("第" + (sum) + "次," + controller.nowPlayer.playerName + "叫了" + controller.nowPlayer.callScore + "分");
                        sum++;
                    }

                    controller.lunPlayer();//换下一个叫

                }


                if (sum == 4) {
                    controller.thanSize();
                    System.out.println("叫分计时器结束");
                    callTimer.stop();//停下计时器
                }
            }


        }
//

    };


}
