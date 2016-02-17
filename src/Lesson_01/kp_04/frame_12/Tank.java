package Lesson_01.kp_04.frame_12;

import Lesson_01.kp_04.frame_04.Bullet;
import Lesson_01.kp_04.frame_06.BattleField;
import Lesson_01.kp_04.frame_08.ActionField;

/**
 * Created by Юрий on 12.02.2016.
 */
public class Tank {
    private int UP = 1;
    private int DOWN = 2;
    private int LEFT = 3;
    private int RIGHT = 4;

    private int direction;
    private int x;
    private int y;
    private int speed = 10;
    private ActionField af;
    private BattleField bf;

    public Tank(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, 1);
    }

    public Tank(ActionField af, BattleField bf, int x, int y, int direction) {
        this.af = af;
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getDirection() {
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

    public void turn(int direction) throws Exception {
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

    public void moveRandom() {
        // TODO: 16.02.2016
    }

    public void moveToQuadrant() {
        // TODO: 17.02.2016
    }

    public void clean() throws Exception {

    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }
}
