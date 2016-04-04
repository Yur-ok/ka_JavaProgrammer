package Lesson_02.kp_06.tanksGame;

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
    private Tank defender;
    private Tank aggressor;
    private Bullet bullet;
    private int amountOfBriks;


    public void processMove(Tank tank) throws Exception {
        this.defender = tank;
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

    public void processTurn(Tank tank) throws Exception {
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
//        clean();
//        moveRandom();
//        createAggressor(aggressor);
    }

    private boolean processInterception() throws Exception {
        String coord;

        coord = getQuadrant(bullet.getX(), bullet.getY());

//        int x = Integer.parseInt(coord.substring(coord.indexOf("_") + 1));
//        int y = Integer.parseInt(coord.substring(0, coord.indexOf("_")));
        int x = Integer.parseInt(coord.split("_")[1]);
        int y = Integer.parseInt(coord.split("_")[0]);

        if (x >= 0 && x < 9 && y >= 0 && y < 9) {
            if (!battleField.scanQuadrant(y, x).trim().isEmpty()) {
                battleField.updateQuadrant(y, x, "");
                return true;
            }
        }
        return false;
    }

    public String getQuadrant(int x, int y) {
        return y / 64 + "_" + x / 64;
    }

    public String getQuadrantXY(int v, int h) {
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

    public void moveToQuadrant(Tank tank, int v, int h) throws Exception {
        this.defender = tank;

        String coordinates = getQuadrantXY(v, h);
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
        defender = new Tank(this, battleField);

        String location = battleField.getAggressorLocation();
        aggressor = new Tank(this, battleField, Integer.parseInt(location.split("_")[1]),
                Integer.parseInt(location.split("_")[0]), Direction.DOWN);
        bullet = new Bullet(-100, -100, Direction.NONE);

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

        //defender
        g.setColor(new Color(34, 255, 18));
        g.fillRect(defender.getX(), defender.getY(), 64, 64);

        //defender gun
        g.setColor(new Color(255, 40, 0));
        if (defender.getDirection() == Direction.UP) {
            g.fillRect(defender.getX() + 20, defender.getY(), 24, 34);
        } else if (defender.getDirection() == Direction.DOWN) {
            g.fillRect(defender.getX() + 20, defender.getY() + 30, 24, 34);
        } else if (defender.getDirection() == Direction.LEFT) {
            g.fillRect(defender.getX(), defender.getY() + 20, 34, 24);
        } else {
            g.fillRect(defender.getX() + 30, defender.getY() + 20, 34, 24);
        }

        //aggressor
        g.setColor(new Color(255, 40, 0));
        g.fillRect(aggressor.getX(), aggressor.getY(), 64, 64);

        //aggressor gun
        g.setColor(new Color(34, 255, 18));
        if (aggressor.getDirection() == Direction.UP) {
            g.fillRect(aggressor.getX() + 20, aggressor.getY(), 24, 34);
        } else if (aggressor.getDirection() == Direction.DOWN) {
            g.fillRect(aggressor.getX() + 20, aggressor.getY() + 30, 24, 34);
        } else if (aggressor.getDirection() == Direction.LEFT) {
            g.fillRect(aggressor.getX(), aggressor.getY() + 20, 34, 24);
        } else {
            g.fillRect(aggressor.getX() + 30, aggressor.getY() + 20, 34, 24);
        }

        //bullet
        g.setColor(new Color(255, 255, 0));
        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
    }
}