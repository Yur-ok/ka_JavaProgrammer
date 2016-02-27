package Lesson_01.kp_05.frame_09;

/**
 * Created by Юрий on 12.02.2016.
 */
public class Bullet {

    private final int SPEED = 5;
    private int x;
    private int y;
    private int direction;

    public Bullet(int x, int y, int direction) {
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

    public int getDirection() {
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
}
