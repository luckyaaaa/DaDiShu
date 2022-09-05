package com.doudizhu.Model;


import com.doudizhu.Controller.Controller;
import com.doudizhu.View.UI;

import java.util.Random;


/**
 * @Author Lucky友人a
 * @Date 2022/8/31 -17:02
 */

public class Player extends PlayerFather {


    public Player(Controller controller, String playerName, int score) {
        super(controller, playerName, score);
    }

    @Override
    public int callDiZhu() {

        int i = 4-controller.baseScore;
        //比如一开始底分0，随机0，1，2，3都可以，放数组里1，2，3，0分都可以，要是底分是2，随机只能2，范围0，1放进数组里是0，3分
        System.out.println("玩家A的分数选项框的显示");
        switch (i) {
            case 4:
                UI.gameFrame.gamePanel.btnSco1.setVisible(true);
                UI.gameFrame.gamePanel.btnSco2.setVisible(true);
                UI.gameFrame.gamePanel.btnSco3.setVisible(true);
                UI.gameFrame.gamePanel.btnSco0.setVisible(true);
                break;
            case 3:
                UI.gameFrame.gamePanel.btnSco2.setVisible(true);
                UI.gameFrame.gamePanel.btnSco3.setVisible(true);
                UI.gameFrame.gamePanel.btnSco0.setVisible(true);
                break;
            case 2:
                UI.gameFrame.gamePanel.btnSco3.setVisible(true);
                UI.gameFrame.gamePanel.btnSco0.setVisible(true);
                break;

        }
        return 0;
    }
}



