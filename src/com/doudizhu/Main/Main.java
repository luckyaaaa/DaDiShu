package com.doudizhu.Main;

import com.doudizhu.Controller.Controller;
import com.doudizhu.View.UI;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @Author Lucky友人a
 * @Date 2022/8/30 -14:30
 */

public class Main {
    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {

        Controller controller = new Controller();
        new UI(controller);

    }
}
