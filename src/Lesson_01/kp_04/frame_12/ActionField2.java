package Lesson_01.kp_04.frame_12;

import Lesson_01.kp_04.frame_04.Bullet;
import Lesson_01.kp_04.frame_06.BattleField;
import Lesson_01.kp_04.frame_10.Tank;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Юрий on 12.02.2016.
 */
public class ActionField2 extends JPanel {

    private final boolean COLORDED_MODE = false;
    private BattleField battleField;
    private Tank tank;
    private Bullet bullet;


    public void processMove(Tank tank) throws Exception {

    }

    public void processTurn(Tank tank) throws Exception {

    }

    public void processFire(Bullet bullet) throws Exception {

    }

    public void runTheGame() throws Exception {

    }

    private boolean processInterception(String name) throws Exception {
        String coord = null;

        if (name.equals("tank")) {
            coord = getQuadrant(tank.getX(), tank.getY());
        } else {
            coord = getQuadrant(bullet.getX(), bullet.getY());
        }

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
            if (battleField.scanQuadrant(y, x).trim().isEmpty()) {
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

    public ActionField2() throws Exception {

        battleField = new BattleField();
        tank = new Tank();
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
