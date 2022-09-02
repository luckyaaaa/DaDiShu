package com.doudizhu.View;

import javax.swing.*;
import java.awt.*;

/**
 * @Author Lucky友人a
 * @Date 2022/8/31 -10:41
 */

public class OptionGamesFrame extends JFrame {
    public OptionGamesFrame.optionJPanel optionJPanel;
    public JLabel animationSpeed = new JLabel("动画速度");

    public ButtonGroup btnGroup = new ButtonGroup();//起作用范围，让选项框只能选1个
    public JRadioButtonMenuItem slowSpeed = new JRadioButtonMenuItem("慢");
    public JRadioButtonMenuItem normalSpeed = new JRadioButtonMenuItem("正常", true);
    public JRadioButtonMenuItem fastSpeed = new JRadioButtonMenuItem("快");
    public JLabel otherOp = new JLabel("其他");
    public JCheckBox musicOp = new JCheckBox("音乐", true);//单选框
    public JLabel playerName = new JLabel("玩家姓名");
    public JLabel playerMe = new JLabel("自己");
    public JLabel playerE = new JLabel("东家");
    public JLabel playerW = new JLabel("西家");
    public JTextField playerMeJText = new JTextField();//自己
    public JTextField playerEJText = new JTextField();//东家
    public JTextField playerWJText = new JTextField();//西家
    public JButton sureBtn = new JButton("确定");
    public JButton cancelBtn = new JButton("取消");

    public OptionGamesFrame() {
        setBounds(590, 180, 300, 300);
        setUndecorated(true);//设置窗口无修饰
        getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);//采用指定的窗口装饰风格
        setTitle("选项");
        setResizable(false);//设置不能修改大小
        optionJPanel = new OptionGamesFrame.optionJPanel();
        add(optionJPanel);


    }

    class optionJPanel extends JPanel {
        public optionJPanel() {
            setLayout(null);//自由布局
            animationSpeed.setBounds(20, 0, 60, 30);//添加位置和大小
            add(animationSpeed);
            btnGroup.add(slowSpeed); //按钮组添加它给它限制成单选
            btnGroup.add(normalSpeed);
            btnGroup.add(fastSpeed);
            slowSpeed.setBounds(20, 30, 60, 30);//慢
            normalSpeed.setBounds(20, 60, 60, 30);//正常
            fastSpeed.setBounds(20, 90, 60, 30);//快
            add(slowSpeed); //添加到JPanel
            add(normalSpeed);
            add(fastSpeed);

            otherOp.setBounds(150, 0, 60, 30);//其他
            musicOp.setBounds(150, 30, 60, 30);//音效
            add(musicOp);
            add(otherOp);
            playerName.setBounds(20, 120, 60, 30);//玩家名称
            add(playerName);
            playerMe.setBounds(20, 150, 60, 30);//玩家自己
            add(playerMe);
            playerMeJText.setBounds(60, 155, 80, 25);//玩家自己文本框
            add(playerMeJText);

            playerWJText.setBounds(60, 185, 80, 25);//西甲文本框
            add(playerWJText);
            playerEJText.setBounds(60, 215, 80, 25);//东家文本框
            add(playerEJText);
            playerE.setBounds(20, 180, 60, 30);//东家
            add(playerE);
            playerW.setBounds(20, 210, 60, 30);//西家
            add(playerW);
            sureBtn.setBounds(180, 170, 85, 25);//确认按钮
            add(sureBtn);
            cancelBtn.setBounds(180, 210, 85, 25);//取消按钮
            add(cancelBtn);

        }
    }

}
