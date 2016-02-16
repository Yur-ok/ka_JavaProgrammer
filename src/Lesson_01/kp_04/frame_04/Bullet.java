package Lesson_01.kp_04.frame_04;

/**
 * Created by Юрий on 12.02.2016.
 */
public class Bullet {

    private int speed = 5;
    private int x;
    private int y;
    private int direction;


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
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
