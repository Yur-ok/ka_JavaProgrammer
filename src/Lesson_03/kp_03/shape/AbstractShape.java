package Lesson_03.kp_03.shape;

import java.awt.*;

/**
 * Created by Юрий on 07.04.2016.
 */
public abstract class AbstractShape implements Drawable {

    protected Color color;
    protected Graphics2D stroke;

    public Color getColor() {
        return color;
    }
}
