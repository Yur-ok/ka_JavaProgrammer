package Lesson_03.kp_05.BattleField;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

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
    private T34 defender;
    private Tiger aggressor;
    private Bullet bullet;
    private int amountOfBriks;


    public void processMove(AbstractTank tank) throws Exception {
        this.defender = (T34) tank;
        Direction direction = tank.getDirection();
        int step = 1;
        int covered = 0;

        // check limits x: 0, 513; y: 0, 513
        if ((tank.getDirection() == Direction.UP && tank.getY() == 0) || (tank.getDirection() == Direction.DOWN && tank.getY() >= 512)
                || (tank.getDirection() == Direction.UP.LEFT && tank.getX() == 0) || (tank.getDirection() == Direction.RIGHT && tank.getX() >= 512)) {
            System.out.println("[illegal move] direction: " + tank.getDirection() + " tankX: " + tank.getX() +
                    ", tankY: " + tank.getY());
            return;
        }

        tank.turn(direction);

        while (covered < 64) {
            if (tank.getDirection() == Direction.UP) {
                tank.updateY(-step);
                System.out.println("[move up] direction: " + tank.getDirection() + " tankX: " + tank.getX() +
                        ", tankY: " + tank.getY());
            } else if (tank.getDirection() == Direction.DOWN) {
                tank.updateY(step);
                System.out.println("[move down] direction: " + tank.getDirection() + " tankX: " + tank.getX() +
                        ", tankY: " + tank.getY());
            } else if (tank.getDirection() == Direction.LEFT) {
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

    public void processTurn(AbstractTank tank) throws Exception {
        repaint();
    }

    public void processFire(Bullet bullet) throws Exception {

        this.bullet = bullet;

        while ((bullet.getX() > -14 && bullet.getX() < 592) && (bullet.getY() > -14 && bullet.getY() < 592)) {
            if (defender.getDirection() == Direction.UP) {
                bullet.updateY(-1);
            } else if (defender.getDirection() == Direction.DOWN) {
                bullet.updateY(1);
            } else if (defender.getDirection() == Direction.LEFT) {
                bullet.updateX(-1);
            } else if (defender.getDirection() == Direction.RIGHT) {
                bullet.updateX(1);
            }
            Thread.sleep(bullet.getSPEED());
            if (processInterception()) {
                bullet.destroy();
                amountOfBriks--;
            }
            repaint();
        }
    }

    public void runTheGame() throws Exception {
        defender.fire();
        defender.fire();
        defender.fire();
        defender.fire();
        defender.fire();
    }

    private boolean processInterception() throws Exception {
        String bulletCoord;

        bulletCoord = getQuadrant(bullet.getX(), bullet.getY());

//        int x = Integer.parseInt(bulletCoord.substring(bulletCoord.indexOf("_") + 1));
//        int y = Integer.parseInt(bulletCoord.substring(0, bulletCoord.indexOf("_")));
        int x = Integer.parseInt(bulletCoord.split("_")[1]);
        int y = Integer.parseInt(bulletCoord.split("_")[0]);

        if (x >= 0 && x < 9 && y >= 0 && y < 9) {
            if (!battleField.scanQuadrant(y, x).trim().isEmpty()) {
                battleField.updateQuadrant(y, x, "");
                return true;
            }
        }

        //check aggressor
        if (checkInterception(getQuadrant(aggressor.getX(), aggressor.getY()), bulletCoord)) {
            aggressor.destroy();
            return true;
        }

        //check defender
/*
        if (checkInterception(getQuadrant(defender.getX(), defender.getY()), bulletCoord)) {
            defender.destroy();
            return true;
        }
*/
        return false;
    }

    private boolean checkInterception(String tankCoord, String bulletCoord) {

        int oy = Integer.parseInt(tankCoord.split("_")[0]);
        int ox = Integer.parseInt(tankCoord.split("_")[1]);

        int qy = Integer.parseInt(bulletCoord.split("_")[0]);
        int qx = Integer.parseInt(bulletCoord.split("_")[1]);

        if (oy >= 0 && oy < 9 && ox >= 0 && ox < 9) {
            if (oy == qy && ox == qx) {
                return true;
            }
        }
        return false;
    }

    public String getQuadrant(int x, int y) {
        return y / 64 + "_" + x / 64;
    }

    public String getQuadrantYX(int v, int h) {
        if (v > 9) {
            v = 9;
        } else if (h > 9) {
            h = 9;
        }
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

    public void moveRandom() throws Exception {
        Random r = new Random();
        int i;
        while (true) {
            i = r.nextInt(5);
            if (i > 0) {
                if (i == 0) {
                    defender.turn(Direction.NONE);
                } else if (i == 1) {
                    defender.turn(Direction.UP);
                } else if (i == 2) {
                    defender.turn(Direction.DOWN);
                } else if (i == 3) {
                    defender.turn(Direction.LEFT);
                } else {
                    defender.turn(Direction.RIGHT);
                }
                defender.move();
            }
        }
    }

    public void moveToQuadrant(AbstractTank tank, int v, int h) throws Exception {
        this.defender = (T34) tank;

        String coordinates = getQuadrantYX(v, h);
        int separator = coordinates.indexOf("_");
        int y = Integer.parseInt(coordinates.substring(0, separator));
        int x = Integer.parseInt(coordinates.substring(separator + 1));

        while (tank.getX() < x) {
            tank.turn(Direction.RIGHT);
            repaint();
            if (!battleField.scanQuadrant((tank.getY() / 64), (tank.getX() / 64) + 1).trim().isEmpty()) {
                tank.fire();
            } else {
                tank.move();
            }
        }
        while (tank.getX() > x) {
            tank.turn(Direction.LEFT);
            repaint();
            if (!battleField.scanQuadrant((tank.getY() / 64), (tank.getX() / 64) - 1).trim().isEmpty()) {
                tank.fire();
            } else {
                tank.move();
            }
        }
        while (tank.getY() < y) {
            tank.turn(Direction.DOWN);
            repaint();
            if (!battleField.scanQuadrant((tank.getY() / 64) + 1, (tank.getX() / 64)).trim().isEmpty()) {
                tank.fire();
            } else {
                tank.move();
            }
        }
        while (tank.getY() > y) {
            tank.turn(Direction.UP);
            repaint();
            if (!battleField.scanQuadrant((tank.getY() / 64) - 1, (tank.getX() / 64)).trim().isEmpty()) {
                tank.fire();
            } else {
                tank.move();
            }
        }
    }

    public void clean() throws Exception {
        long start = System.currentTimeMillis();
        defender.moveToQuadrant(1, 1);
        for (int i = 0, k = 2; i < battleField.getDimensionX(); i++, k++) {
            for (int j = 1; j < battleField.getDimensionY(); j++) {
                if (battleField.scanQuadrant(i, j).trim().equals("B")) {
                    defender.turn(Direction.RIGHT);
                    defender.fire();
                }
            }
            if (k <= 9) {
                defender.moveToQuadrant(k, 1);
                System.out.println("Move to " + k + ", 1");
            }
        }
        if (amountOfBriks == 0) {
            defender.moveToQuadrant(5, 5);
            System.out.println("Battle Field is clean!!!");
            long finish = System.currentTimeMillis() - start;
            System.out.println(finish / 1000);
        }
    }

    private int numbersOFBriks() {
        int count = 0;
        for (int i = 0; i < battleField.getDimensionX(); i++) {
            for (int j = 0; j < battleField.getDimensionY(); j++) {
                if (battleField.scanQuadrant(i, j).equals("B")) {
                    count++;
                }
            }
        }
        System.out.println(count);
        return amountOfBriks = count;
    }

    public ActionField() throws Exception {

        battleField = new BattleField();
        defender = new T34(this, battleField);

        String location = battleField.getAggressorLocation();
        aggressor = new Tiger(this, battleField, Integer.parseInt(location.split("_")[1]),
                Integer.parseInt(location.split("_")[0]), Direction.DOWN);
        bullet = new Bullet(-100, -100, Direction.NONE);

        JFrame frame = new JFrame("Tiger Armor check");
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
                    String coordinates = getQuadrantYX(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates.substring(0, separator));
                    int x = Integer.parseInt(coordinates.substring(separator + 1));
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x, y, 64, 64);
                }
            }
        }

        defender.draw(g);
        aggressor.draw(g);
        bullet.draw(g);
    }
}