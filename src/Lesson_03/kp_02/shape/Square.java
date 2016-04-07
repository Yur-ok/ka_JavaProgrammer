package Lesson_03.kp_02.shape;

import java.awt.*;

/**
 * Created by Юрий on 07.04.2016.
 */
public class Square extends Shape {

    @Override
    public void draw(Graphics g) {
        g.drawRect(30, 180, 100, 100);
        g.setColor(new Color(141, 0, 255));
        g.fillRect(30, 180, 100, 100);
    }
}
