package Lesson_03.kp_03.shape;

import java.awt.*;

/**
 * Created by Юрий on 07.04.2016.
 */
public class Triangle extends AbstractShape {

    public Triangle() {
        color = new Color(49, 222, 67);
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoint = {400, 480, 320};
        int[] yPoint = {30, 130, 130};
        g.drawPolygon(xPoint, yPoint, 3);
        g.setColor(color);
        g.fillPolygon(xPoint, yPoint, 3);
    }
}
