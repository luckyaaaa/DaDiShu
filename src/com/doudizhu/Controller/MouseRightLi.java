package com.doudizhu.Controller;


import com.doudizhu.View.UI;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * @Author Lucky友人a
 * @Date 2022/8/28 -21:55
 */

public class MouseRightLi extends MouseAdapter {
    public ButtonGroup poupButtonBg = new ButtonGroup();//起作用范围，让选项框只能选1个
    public JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal 风格");
    public JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus 风格", true);
    public JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows 风格");
    public JRadioButtonMenuItem windowsClassicItem = new JRadioButtonMenuItem("Windows 经典风格");
    public JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif 风格");
    public JPopupMenu jPopupMenu = new JPopupMenu();//右键菜单也是就弹出菜单

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        if (e.getButton() == MouseEvent.BUTTON3) {// right click
            poupButtonBg.add(metalItem);
            poupButtonBg.add(nimbusItem);
            poupButtonBg.add(windowsItem);
            poupButtonBg.add(windowsClassicItem);
            poupButtonBg.add(motifItem);
            metalItem.addActionListener(e1 -> {
                String actionCommand = e1.getActionCommand();
                try {
                    changeFlavor(actionCommand);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            nimbusItem.addActionListener(e12 -> {
                String actionCommand = e12.getActionCommand();
                try {
                    changeFlavor(actionCommand);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            windowsItem.addActionListener(e13 -> {
                String actionCommand = e13.getActionCommand();
                try {
                    changeFlavor(actionCommand);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            windowsClassicItem.addActionListener(e14 -> {
                String actionCommand = e14.getActionCommand();
                try {
                    changeFlavor(actionCommand);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            motifItem.addActionListener(e15 -> {
                String actionCommand = e15.getActionCommand();
                try {
                    changeFlavor(actionCommand);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            jPopupMenu.add(metalItem);
            jPopupMenu.add(nimbusItem);
            jPopupMenu.add(windowsItem);
            jPopupMenu.add(windowsClassicItem);
            jPopupMenu.add(motifItem);


            jPopupMenu.show(e.getComponent(), e.getX(), e.getY());//获取位置
        }

    }

    public void changeFlavor(String command) throws Exception {
        switch (command) {
            case "Metal 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case "Nimbus 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");//我喜欢的风格
                break;
            case "Windows 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case "Windows 经典风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                break;
            case "Motif 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); //复古界面,丑
                break;
        }

        //刷新组件的外观
        SwingUtilities.updateComponentTreeUI(UI.welcomeFrame.getContentPane());
        SwingUtilities.updateComponentTreeUI(UI.gameFrame.getContentPane());//父组件以及子组件
    }
}
