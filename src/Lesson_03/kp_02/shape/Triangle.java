package Lesson_03.kp_02.shape;

import java.awt.*;

/**
 * Created by Юрий on 07.04.2016.
 */
public class Triangle extends Lesson_03.kp_02.shape.Shape {
    public Triangle() {
    }

    @Override

    public void draw(Graphics g) {
        int[] xPoint = {400, 480, 320};
        int[] yPoint = {30, 130, 130};
        g.setColor(new Color(0, 0, 0));
        g.drawPolygon(xPoint, yPoint, 3);
        g.setColor(new Color(49, 222, 67));
        g.fillPolygon(xPoint, yPoint, 3);
    }
}
