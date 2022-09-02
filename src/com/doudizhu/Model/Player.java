package com.doudizhu.Model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author Lucky友人a
 * @Date 2022/8/31 -17:02
 */

public class Player {

    public String playerName;
    public int Score;
    public ArrayList<PaperCard> frontView;
    public boolean nextPlayer;//下家
    //叫分、
    public Player(String playerName, int score, boolean nextPlayer) {
        this.playerName = playerName;
        Score = score;
        this.frontView =  new ArrayList<>();
        this.nextPlayer = nextPlayer;
    }

    public void sort (){
        Collections.sort(frontView, new Comparator<PaperCard>() {
            @Override
            public int compare(PaperCard o1, PaperCard o2) {
                return o1.cardNum - o2.cardNum;
            }
        });
    }
}


