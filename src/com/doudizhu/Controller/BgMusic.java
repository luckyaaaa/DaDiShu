package com.doudizhu.Controller;

import javax.sound.sampled.*;
import java.io.IOException;

/**
 * @Author Lucky友人a
 * @Date 2022/8/31 -9:18
 */

public class BgMusic extends Thread {
    public Clip clip;
    public Controller controller;

    public BgMusic(Controller controller) {
        this.controller=controller;
    }
    public void beginMusic() throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new java.io.File("D:\\workspace\\JAVAworkspace\\JAVAworkspace\\resources\\music\\bg.wav"));
        DataLine.Info info =
                new DataLine.Info(Clip.class, audioInputStream.getFormat());
        clip = (Clip) AudioSystem.getLine(info);
        clip.addLineListener(new LineListener() {
            public void update(LineEvent e) {
                if (e.getType() == LineEvent.Type.STOP) {
                    synchronized (clip) {
                        clip.notify();
                    }
                }
            }
        });
        clip.open(audioInputStream);
        clip.start();
        synchronized (clip) {
            clip.wait();
        }
        clip.close();
    }

    @Override
    public void run() {
        while (true) {
            try {
                controller.bgMusic.beginMusic();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
