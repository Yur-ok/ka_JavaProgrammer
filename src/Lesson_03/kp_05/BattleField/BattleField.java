package Lesson_03.kp_05.BattleField;

import java.util.Random;

/**
 * Created by Юрий on 12.02.2016.
 */
public class BattleField {

    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;

    private String[][] battleField = {
            {"B", " ", "B", "B", " ", "B", "B", " ", "B"},
            {" ", " ", " ", "B", " ", "B", " ", " ", " "},
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {" ", "B", " ", "B", " ", "B", " ", "B", " "},
            {"B", " ", "B", " ", "B", " ", "B", " ", "B"},
            {" ", "B", " ", "B", " ", "B", " ", "B", " "},
            {"B", " ", " ", " ", " ", " ", " ", " ", "B"},
            {" ", " ", " ", "B", "B", "B", " ", " ", " "},
            {"B", " ", " ", "B", " ", "B", " ", " ", "B"}
    };


    public BattleField() {
    }

    public BattleField(String[][] battleField) {
        this.battleField = battleField;
    }

    public String scanQuadrant(int v, int h) {
        return battleField[v][h];
    }

    public void updateQuadrant(int v, int h, String str) {
        battleField[v][h] = str;
    }

    public int getDimensionX() {
        return battleField.length;
    }

    public int getDimensionY() {
        return battleField.length;
    }

    public int getBF_WIDTH() {
        return BF_WIDTH;
    }

    public int getBF_HEIGHT() {
        return BF_HEIGHT;
    }


    public String getAggressorLocation() {
        Random r = new Random();
        int num = r.nextInt(9);
        String coord;
        String[] freeCells = new String[9];

        for (int i = 0; i < battleField[0].length; i++) {
            if (scanQuadrant(0, i).trim().isEmpty()) {
                freeCells[i] = "0_" + (i * 64);
            }
        }
//        System.out.println(Arrays.toString(freeCells));

        while (freeCells[num] == null) {
            num = r.nextInt(9);
        }
        coord = freeCells[num];
//        return coord;
        return "0_64";
    }
}
