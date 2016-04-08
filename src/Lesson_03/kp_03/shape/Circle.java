package Lesson_03.kp_03.shape;

import java.awt.*;

/**
 * Created by Юрий on 07.04.2016.
 */
public class Circle extends AbstractShape {

    public Circle() {
        color = new Color(255, 189, 61);
    }

    @Override
    public void draw(Graphics g) {
        stroke = (Graphics2D) g;
        stroke.setStroke(new BasicStroke(9));

        g.drawOval(30, 30, 100, 100);
        g.setColor(color);
        g.fillOval(30, 30, 100, 100);
    }
}
