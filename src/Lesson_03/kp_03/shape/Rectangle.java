package Lesson_03.kp_03.shape;

import java.awt.*;

/**
 * Created by Юрий on 07.04.2016.
 */
public class Rectangle extends AbstractShape {

    public Rectangle() {
        color = new Color(234, 123, 213);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(150, 30, 150, 100);
        g.setColor(color);
        g.fillRect(150, 30, 150, 100);
    }
}
