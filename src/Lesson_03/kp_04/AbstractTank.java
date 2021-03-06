package Lesson_03.kp_04;

import java.awt.*;

/**
 * Created by Юрий on 12.02.2016.
 */
public abstract class AbstractTank implements Destroyable, Drawable {

    private String color;
    private int crew;

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

    protected Direction direction;
    protected int x;
    protected int y;
    protected int speed = 3; //10
    protected Color tankColor;
    protected Color gunColor;

    private ActionField af;
    private BattleField bf;

    public AbstractTank() {
    }

    public AbstractTank(ActionField af, BattleField bf) {
        this.af = af;
        this.bf = bf;
    }

    public AbstractTank(ActionField af, BattleField bf, int x, int y, Direction direction) {
        this.af = af;
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turn(Direction direction) throws Exception {
        this.direction = direction;
        af.processTurn(this);
    }

    public void move() throws Exception {
        af.processMove(this);
    }

    public void fire() throws Exception {
        Bullet bullet = new Bullet((x + 25), (y + 25), direction);
        af.processFire(bullet);
    }

    public void moveRandom() throws Exception {
        af.moveRandom();
    }


    public void moveToQuadrant(int v, int h) throws Exception {
        af.moveToQuadrant(this, v, h);
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }

//    @Override
//    public String toString() {
//        return "Tank has next parameters: \nColor = " + getColor() + "\nSpeed = " + getSpeed() + "\nCrew = " + getCrew();
//    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public void destroy() {
        x = -100;
        y = -100;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        //defender
        g.setColor(tankColor);
        g.fillRect(this.getX(), this.getY(), 64, 64);

        //this gun
        g.setColor(gunColor);
        if (this.getDirection() == Direction.UP) {
            g.fillRect(this.getX() + 20, this.getY(), 24, 34);
        } else if (this.getDirection() == Direction.DOWN) {
            g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
        } else if (this.getDirection() == Direction.LEFT) {
            g.fillRect(this.getX(), this.getY() + 20, 34, 24);
        } else {
            g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
        }
    }
}
