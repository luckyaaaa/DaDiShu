package com.doudizhu.Model;

import com.doudizhu.Controller.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * @Author Lucky友人a
 * @Date 2022/9/2 -11:17
 */

public class PlayerFather {
    public String playerName;
    public int Score;
    public ArrayList<PaperCard> frontView;
    public Controller controller;
    public int callScore;//叫分
    public boolean isDiZhu;//是否地主
    public PlayerFather( Controller controller, String playerName, int score) {
        this.controller=controller;
        this.playerName = playerName;
        Score = score;
        this.frontView =  new ArrayList<>();

    }



    public void sort (){
        Collections.sort(frontView, new Comparator<PaperCard>() {
            @Override
            public int compare(PaperCard o1, PaperCard o2) {
                return o1.cardNum - o2.cardNum;
            }
        });
    }
    public int callDiZhu() {
        Random random = new Random();
        int i = random.nextInt(4-controller.baseScore);
        System.out.println("随机到的下标是"+i+",还没有放进数组里");

        return i;
    }
}
