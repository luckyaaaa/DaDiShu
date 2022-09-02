package com.doudizhu.View;

import com.doudizhu.Controller.Controller;
import com.doudizhu.Controller.GameActionLis;
import com.doudizhu.Controller.GameWinListener;


import javax.swing.*;
import java.awt.*;

/**
 * @Author Lucky友人a
 * @Date 2022/8/30 -17:10
 */

public class GameFrame extends JFrame {
    public GamePanel gamePanel;
    public Controller controller;

    public GameFrame(Controller controller) {
        this.controller = controller;
        gamePanel = new GamePanel(controller);
        setSize(1100, 700);//设置窗口大小
        Toolkit toolkit = Toolkit.getDefaultToolkit(); // 获取Toolkit对象
        Image icon = toolkit.getImage("resources/img/icon.png"); // 获取图⽚对象
        this.setIconImage(icon); // 设置图标
        setLocationRelativeTo(null);//设置居中
        setTitle("欢乐斗地主");//设置标题
        setResizable(false);//设置不能修改大小
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//点x啥事情都不干
        GameWinListener gameWinListener = new GameWinListener();//给窗口也就是JFrame窗口，安装监听器
        addWindowListener(gameWinListener);//本来是组件. ,因为就在构造函数里面，所以直接用
        add(gamePanel);//添加中间容器

        JMenuBar jMenuBar = new JMenuBar();//菜单栏
        JMenu gameGame = new JMenu("游戏");//游戏
        JMenu helpGame = new JMenu("帮助");//帮助
        jMenuBar.add(gameGame);//菜单栏里添加游戏
        jMenuBar.add(helpGame);

        setJMenuBar(jMenuBar);//注意！添加菜单栏带顶级容器,其他用add
        JMenuItem dealCards = new JMenuItem("发牌");//菜单项
        GameActionLis gameActionLis1 = new GameActionLis(controller);
        dealCards.addActionListener(gameActionLis1);
        dealCards.setActionCommand("dealCards");

        JMenuItem optionGames = new JMenuItem("选项");//菜单项

        JMenuItem scoreGames = new JMenuItem("得分");//菜单项
        JMenuItem exitGames = new JMenuItem("退出");//菜单项
        gameGame.add(dealCards);//将菜单项添加到菜单
        gameGame.add(optionGames);
        gameGame.add(scoreGames);
        gameGame.add(exitGames);

        JMenuItem ruleGame = new JMenuItem("斗地主规则");//菜单项
        JMenuItem relevantGame = new JMenuItem("关于传一斗地主");//菜单项
        helpGame.add(ruleGame);//将菜单项添加到菜单
        helpGame.add(relevantGame);

        GameActionLis gameActionLis = new GameActionLis(controller); //new动作监听
        optionGames.addActionListener(gameActionLis);//添加它
        optionGames.setActionCommand("optionGames");//给它监听名字
        scoreGames.addActionListener(gameActionLis);
        scoreGames.setActionCommand("scoreGames");
        exitGames.addActionListener(gameActionLis);
        exitGames.setActionCommand("exitGames");
        ruleGame.addActionListener(gameActionLis);
        ruleGame.setActionCommand("ruleGame");
        relevantGame.addActionListener(gameActionLis);
        relevantGame.setActionCommand("relevantGame");
    }
}
