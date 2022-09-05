package com.doudizhu.Model;

import java.util.Comparator;

/**
 * @Author Lucky友人a
 * @Date 2022/8/31 -14:14
 */

public class PaperCard{
    //纸牌命名黑桃1、红桃2、梅花3、方块4 ,大小王0
    public int cardColour;//花色
    public int cardNum;//牌值
    public String frontView;//正面图地址
    public String reverseView;//反面图地址
    public boolean cardChoice;//是否选中

    public PaperCard(int cardColour, int cardNum, String frontView, String reverseView, boolean cardChoice) {
        this.cardColour = cardColour;
        this.cardNum = cardNum;
        this.frontView = frontView;
        this.reverseView = reverseView;
        this.cardChoice = cardChoice;
    }


}
