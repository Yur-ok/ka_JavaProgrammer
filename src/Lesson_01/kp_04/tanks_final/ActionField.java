package Lesson_01.kp_04.tanks_final;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Юрий on 12.02.2016.
 */
public class ActionField extends JPanel {

    private final int UP = 1;
    private final int DOWN = 2;
    private final int LEFT = 3;
    private final int RIGHT = 4;

    private final boolean COLORDED_MODE = false;
    private BattleField battleField;
    private Tank tank;
    private Bullet bullet;


    public void processMove(Tank tank) throws Exception {
        this.tank = tank;
        int direction = tank.getDirection();
        int step = 1;
        int covered = 0;

        // check limits x: 0, 512; y: 0, 512
        if ((tank.getDirection() == UP && tank.getY() == 0) || (tank.getDirection() == DOWN && tank.getY() >= 512)
                || (tank.getDirection() == LEFT && tank.getX() == 0) || (tank.getDirection() == RIGHT && tank.getX() >= 512)) {
            System.out.println("[illegal move] direction: " + tank.getDirection() + " tankX: " + tank.getX() +
                    ", tankY: " + tank.getY());
            return;
        }

        tank.turn(direction);

        while (covered < 64) {
            if (tank.getDirection() == UP) {
                tank.updateY(-step);
                System.out.println("[move up] direction: " + tank.getDirection() + " tankX: " + tank.getX() +
                        ", tankY: " + tank.getY());
            } else if (tank.getDirection() == DOWN) {
                tank.updateY(step);
                System.out.println("[move down] direction: " + tank.getDirection() + " tankX: " + tank.getX() +
                        ", tankY: " + tank.getY());
            } else if (tank.getDirection() == LEFT) {
                tank.updateX(-step);
                System.out.println("[move left] direction: " + tank.getDirection() + " tankX: " + tank.getX() +
                        ", tankY: " + tank.getY());
            } else {
                tank.updateX(step);
                System.out.println("[move right] direction: " + tank.getDirection() + " tankX: " + tank.getX() +
                        ", tankY: " + tank.getY());
            }
            covered += step;
            repaint();
            Thread.sleep(tank.getSpeed());
        }
    }

    public void processTurn(Tank tank) throws Exception {
        repaint();
    }

    public void processFire(Bullet bullet) throws Exception {

        this.bullet = bullet;


        while ((bullet.getX() > -14 && bullet.getX() < 592) && (bullet.getY() > -14 && bullet.getY() < 592)) {
            if (tank.getDirection() == UP) {
                bullet.updateY(-1);
            } else if (tank.getDirection() == DOWN) {
                bullet.updateY(1);
            } else if (tank.getDirection() == LEFT) {
                bullet.updateX(-1);
            } else if (tank.getDirection() == RIGHT) {
                bullet.updateX(1);
            }
            repaint();
            Thread.sleep(bullet.getSPEED());
            if (processInterception()) {
                bullet.destroy();
//                amountOfBriks--;
            }
        }
    }

    public void runTheGame() throws Exception {
        tank.fire();
        tank.fire();
        tank.fire();
        tank.move();
        tank.turn(3);
        tank.fire();
    }

    private boolean processInterception() throws Exception {
        String coord = null;

//        if (name.equals("tank")) {
//            coord = getQuadrant(tank.getX(), tank.getY());
//        } else {
        coord = getQuadrant(bullet.getX(), bullet.getY());
//        }

        int x = Integer.parseInt(coord.substring(coord.indexOf("_") + 1));
        int y = Integer.parseInt(coord.substring(0, coord.indexOf("_")));

//        if (name.equals("tank")) {
//            if (tankDirection == RIGHT && !battleField[y][x + 1].trim().isEmpty()) {
//                return true;
//            } else if (tankDirection == LEFT && !battleField[y][x - 1].trim().isEmpty()) {
//                return true;
//            } else if (tankDirection == DOWN && !battleField[y + 1][x].trim().isEmpty()) {
//                return true;
//            } else if (tankDirection == UP && !battleField[y - 1][x].trim().isEmpty()) {
//                return true;
//            }
//        } else {
        if (x >= 0 && x <= 8 && y >= 0 && y <= 8) {
            if (!battleField.scanQuadrant(y, x).trim().isEmpty()) {
                battleField.updateQuadrant(y, x, "");
                return true;
            }
        }
//        }
        return false;
    }

    public String getQuadrant(int x, int y) {
        return y / 64 + "_" + x / 64;
    }

    public String getQuadrantXY(int v, int h) {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

    public ActionField() throws Exception {

        battleField = new BattleField();
        tank = new Tank(this, battleField);
        bullet = new Bullet(-100, -100, -1);

        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(battleField.getBF_WIDTH() + 16, battleField.getBF_HEIGHT() + 39));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                if (COLORDED_MODE) {
                    if (i % 2 == 0) {
                        cc = new Color(252, 241, 177);
                    } else {
                        cc = new Color(233, 243, 255);
                    }
                } else {
                    cc = new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }

        for (int j = 0; j < battleField.getDimensionY(); j++) {
            for (int k = 0; k < battleField.getDimensionX(); k++) {
                if (battleField.scanQuadrant(j, k).equals("B")) {
                    String coordinates = getQuadrantXY(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates.substring(0, separator));
                    int x = Integer.parseInt(coordinates.substring(separator + 1));
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x, y, 64, 64);
                }
            }
        }

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tank.getX(), tank.getY(), 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (tank.getDirection() == 1) {
            g.fillRect(tank.getX() + 20, tank.getY(), 24, 34);
        } else if (tank.getDirection() == 2) {
            g.fillRect(tank.getX() + 20, tank.getY() + 30, 24, 34);
        } else if (tank.getDirection() == 3) {
            g.fillRect(tank.getX(), tank.getY() + 20, 34, 24);
        } else {
            g.fillRect(tank.getX() + 30, tank.getY() + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
    }
}
