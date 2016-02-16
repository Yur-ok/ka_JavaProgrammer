package Lesson_01.kp_04.frame_04;

/**
 * Created by Юрий on 12.02.2016.
 */
public class Bullet {

    private int x;
    private int y;
    private int speed;
    private int direction;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int updateX(int x) {
        if (direction == 3) {
            this.x -= x;
        } else if (direction == 4) {
            this.x += x;
        }
        return this.x;
    }

    public int updateY(int y) {
        if (direction == 1) {
            this.y -= y;
        } else if (direction == 2) {
            this.y += y;
        }
        return this.y;
    }

    public void destroy() {
        x = -100;
        y = -100;
    }
}
