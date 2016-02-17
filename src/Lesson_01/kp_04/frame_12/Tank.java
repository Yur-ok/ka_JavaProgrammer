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

    private int Direction;
    private int X;
    private int Y;
    private int speed = 10;
    private ActionField af;
    private BattleField bf;

    public Tank() {

    }

    public ActionField getActionField() {
        return af;
    }

    public void setActionField(ActionField af) {
        this.af = af;
    }

    public BattleField getBattleField() {
        return bf;
    }

    public void setBattleField(BattleField bf) {
        this.bf = bf;
    }

    public int getDirection() {
        return Direction;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public void turn(int direction) {
        if (Direction != direction) {
            Direction = direction;
        }
    }

    public void move(int direction) throws Exception {
        int step = 1;
        int covered = 0;

        // check limits x: 0, 512; y: 0, 512
        if ((direction == UP && Y == 0) || (direction == DOWN && Y >= 512)
                || (direction == LEFT && X == 0) || (direction == RIGHT && X >= 512)) {
            System.out.println("[illegal move] direction: " + direction + " tankX: " + X + ", tankY: " + Y);
            return;
        }

        turn(direction);

        while (covered < 64) {
            if (direction == UP) {
                Y -= step;
                System.out.println("[move up] direction: " + direction + " tankX: " + X + ", tankY: " + Y);
            } else if (direction == DOWN) {
                Y += step;
                System.out.println("[move down] direction: " + direction + " tankX: " + X + ", tankY: " + Y);
            } else if (direction == LEFT) {
                X -= step;
                System.out.println("[move left] direction: " + direction + " tankX: " + X + ", tankY: " + Y);
            } else {
                X += step;
                System.out.println("[move right] direction: " + direction + " tankX: " + X + ", tankY: " + Y);
            }
            covered += step;
            actionField;
            Thread.sleep(speed);
        }
    }


    public void fire() throws Exception {

        Bullet bullet = new Bullet(-100, -100, -1);
        bullet.updateX(25);
        bullet.updateY(25);

        while ((bullet.getX() > -14 && bullet.getX() < 592) && (bullet.getY() > -14 && bullet.getY() < 592)) {
            if (Direction == UP) {
                bullet.updateY(-1);
            } else if (Direction == DOWN) {
                bullet.updateY(+1);
            } else if (Direction == LEFT) {
                bullet.updateX(-1);
            } else if (Direction == RIGHT) {
                bullet.updateX(+1);
            }
            repaint();
            Thread.sleep(bullet.getSpeed());
            if (processInterception("bullet")) {
                bullet.destroy();
                amountOfBriks--;
            }
        }
    }

    public void moveRandom() {
        // TODO: 16.02.2016
    }

    public void moveToQuadrant() {
        // TODO: 17.02.2016
    }
}
