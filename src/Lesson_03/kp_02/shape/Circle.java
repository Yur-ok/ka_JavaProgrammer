package Lesson_03.kp_02.shape;

import java.awt.*;

/**
 * Created by Юрий on 07.04.2016.
 */
public class Circle extends Shape {
    @Override
    public void draw(Graphics g) {
        g.drawOval(30, 30, 100, 100);
        g.setColor(new Color(255, 189, 61));
        g.fillOval(30, 30, 100, 100);
    }
}
