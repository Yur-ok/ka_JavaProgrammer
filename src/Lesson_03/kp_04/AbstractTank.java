package Lesson_03.kp_04;

/**
 * Created by Юрий on 08.04.2016.
 */
public abstract class AbstractTank {

    protected String color;
    protected int crew;
    protected Direction direction;
    protected int x;
    protected int y;
    protected int speed;
    protected ActionField af;
    protected BattleField bf;

    protected abstract void turn(Direction direction) throws Exception;

    protected abstract void move() throws Exception;

    protected abstract void fire() throws Exception;

    protected abstract void destroy();


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

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

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }
}
