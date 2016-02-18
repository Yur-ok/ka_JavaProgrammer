package Lesson_01.kp_04.tanks_final;

/**
 * Created by Юрий on 12.02.2016.
 */
public class Tank {

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
        // TODO: 18.02.2016
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }
}
