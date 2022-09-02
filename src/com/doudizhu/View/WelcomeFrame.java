package com.doudizhu.View;


import com.doudizhu.Controller.Controller;
import com.doudizhu.Controller.GameWinListener;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author Lucky友人a
 * @Date 2022/8/30 -14:27
 */

public class WelcomeFrame extends JFrame {
    public WelcomePanel welcomePanel;
    public Controller controller;

    public WelcomeFrame(Controller controller) {
        this.controller = controller;

        welcomePanel = new WelcomePanel(controller);
        setSize(1100, 700);//设置位置和大小
        Toolkit toolkit = Toolkit.getDefaultToolkit(); // 获取Toolkit对象
        Image icon = toolkit.getImage("resources/img/icon.png"); // 获取图⽚对象
        this.setIconImage(icon); // 设置图标
        setLocationRelativeTo(null);//设置居中,就不需要设置从哪开始了
        setTitle("欢乐斗地主");//设置标题
        setResizable(false);//设置不能修改大小
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//点x啥事情都不干
        GameWinListener gameWinListener = new GameWinListener();//给窗口也就是JFrame窗口，安装监听器
        addWindowListener(gameWinListener);//本来是组件. ,因为就在构造函数里面，所以直接用

        add(welcomePanel);

    }
}
