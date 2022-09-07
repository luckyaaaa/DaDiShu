package com.doudizhu.View;

import com.doudizhu.Controller.Controller;

import javax.swing.*;


/**
 * @Author Lucky友人a
 * @Date 2022/9/2 -14:45
 */

public class AccountFrame extends JFrame {
    public Controller controller;
    public JLabel basicsLab;
    public JLabel kingLab;
    public JLabel springLab;
    public JLabel basicsBei;
    public JLabel sumBei;
    public JLabel landWin;
    public JLabel farmerFail1;
    public JLabel farmerFail2;
    public JLabel currentSum;

    public AccountFrame(Controller controller) {
        this.controller = controller;

        setSize(600, 300);//设置窗口大小

        setLocationRelativeTo(null);//设置居中
        setTitle("结算面板");//设置标题
        setResizable(false);//设置不能修改大小
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//点x啥事情都不干
        accountJPanel accountJPanel = new accountJPanel();
        add(accountJPanel);

    }

    class accountJPanel extends JPanel {
        public accountJPanel() {
            setLayout(null);
            basicsLab = new JLabel("基础分:3分");
            kingLab = new JLabel("王炸:2倍 X 1");
            springLab = new JLabel("春天:2倍 X 0");
            basicsBei = new JLabel("基础分:2倍 X 2");
            sumBei = new JLabel("总倍数:8");
            landWin = new JLabel("地主 胜利 + 24");
            farmerFail1 = new JLabel("农民 失败 - 12");
            farmerFail2 = new JLabel("农民 失败 - 12");
            currentSum = new JLabel("当前总分:24");

            add(basicsLab);
            add(kingLab);
            add(springLab);
            add(basicsBei);
            add(sumBei);
            add(landWin);
            add(farmerFail1);
            add(farmerFail2);
            add(currentSum);

            basicsLab.setBounds(30,30,120,30);
            kingLab.setBounds(30,60,120,30);
            springLab.setBounds(30,90,120,30);
            basicsBei.setBounds(30,120,120,30);
            sumBei.setBounds(30,150,120,30);


            landWin.setBounds(130,60,120,30);
            farmerFail1.setBounds(130,90,120,30);
            farmerFail2.setBounds(130,120,120,30);
            currentSum.setBounds(130,150,120,30);
        }

    }
}
