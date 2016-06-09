package Lesson_03.kp_02.shape;

import java.awt.*;

/**
 * Created by Юрий on 07.04.2016.
 */
public class Rectangle extends Shape {
    public Rectangle() {
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.drawRect(150, 30, 150, 100);
        g.setColor(new Color(234, 123, 213));
        g.fillRect(150, 30, 150, 100);
    }
}
