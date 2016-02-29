package Lesson_02.kp_05;

/**
 * Created by Юрий on 12.02.2016.
 */
public class Tank {

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

    private Direction direction;
    private int x;
    private int y;
    protected int speed = 10;
    private ActionField af;
    private BattleField bf;

    public Tank() {
    }

    public Tank(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, Direction.UP);
    }

    public Tank(ActionField af, BattleField bf, int x, int y, Direction direction) {
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

    @Override
    public String toString() {
        return "Tank has next parameters: \nColor = " + getColor() + "\nSpeed = " + getSpeed() + "\nCrew = " + getCrew();
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public void destroy() {
        x = -100;
        y = -100;
    }
}
