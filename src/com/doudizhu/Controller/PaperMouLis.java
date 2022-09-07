package com.doudizhu.Controller;

import com.doudizhu.Model.PaperCard;
import com.doudizhu.Model.Player;
import com.doudizhu.View.UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author Lucky友人a
 * @Date 2022/9/6 -10:29
 */

public class PaperMouLis extends MouseAdapter {

    public Controller controller;

    public PaperMouLis(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
//        System.out.println("触发了鼠标监听牌");
        if (!((PaperCard) e.getSource()).cardChoice) { //这是未选中的牌为false，点击上升
            ((PaperCard) e.getSource()).cardChoice=true;//e.getSource()获得对象
            System.out.println("向上");


        } else {//选中的，点击下降
            System.out.println("向下");
            ((PaperCard) e.getSource()).cardChoice=false;
        }
        UI.gameFrame.gamePanel.gameSouthPanel.repaint(); //重绘界面
    }
}
