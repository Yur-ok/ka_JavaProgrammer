package Lesson_03.kp_04;

import java.awt.*;

/**
 * Created by Юрий on 12.02.2016.
 */
public class Bullet implements Drawable, Destroyable {

    private final int SPEED = 5;
    private int x;
    private int y;
    private Direction direction;

    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSPEED() {
        return SPEED;
    }

    public Direction getDirection() {
        return direction;
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }

    public void destroy() {
        x = -100;
        y = -100;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(255, 255, 0));
        g.fillRect(this.getX(), this.getY(), 14, 14);
    }
}
