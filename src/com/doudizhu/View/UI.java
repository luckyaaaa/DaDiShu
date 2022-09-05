package com.doudizhu.View;

import com.doudizhu.Controller.Controller;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author Lucky友人a
 * @Date 2022/8/30 -15:50
 */

public class UI {
    public static WelcomeFrame welcomeFrame;
    public static GameFrame gameFrame;
    public static OptionGamesFrame optionGamesFrame;
    public Controller controller;

    public UI(Controller controller) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {

        this.controller = controller;

        welcomeFrame = new WelcomeFrame(controller);

        gameFrame = new GameFrame(controller);
        optionGamesFrame = new OptionGamesFrame();
        AccountFrame accountFrame = new AccountFrame(controller);

        try {
            controller.mouseRightLi.changeFlavor("Nimbus 风格");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Font sysFont = new Font("黑体", 1, 15); //修改全局系统字体，自己的还得自己添加
//        initGobalFont(sysFont);

//        welcomeFrame.setVisible(true);
        gameFrame.setVisible(true);
//        accountFrame.setVisible(true);

    }


//设置全局字体
    public static void initGobalFont(Font font) {
        FontUIResource fontResource
                = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                System.out.println(key);
                UIManager.put(key, fontResource);
            }
        }
    }
}

