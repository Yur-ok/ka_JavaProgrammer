package Lesson_01.kp_04.frame_02;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Юрий on 12.02.2016.
 */
public class ActionField extends JPanel {

    private final boolean COLORDED_MODE = false;
    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;

    public ActionField() throws Exception {
        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH + 16, BF_HEIGHT + 39));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }


}
