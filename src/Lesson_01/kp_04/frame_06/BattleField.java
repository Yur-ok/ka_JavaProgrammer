package Lesson_01.kp_04.frame_06;

/**
 * Created by Юрий on 12.02.2016.
 */
public class BattleField {

    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;

    private String[][] battleField = {
            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {" ", "B", " ", "B", " ", "B", " ", "B", " "},
            {"B", " ", "B", " ", "B", " ", "B", " ", "B"},
            {" ", "B", " ", "B", " ", "B", " ", "B", " "},
            {"B", " ", " ", " ", " ", " ", " ", " ", "B"},
            {" ", " ", " ", "B", "B", "B", " ", " ", " "},
            {"B", " ", " ", "B", " ", "B", " ", " ", "B"}
    };


    public String scanQuadrant(int v, int h) {

        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

    public void updateQuadrant(int x, int y, String str) {

        battleField[x][y] = str;
    }

    public int getDimensionX() {

        return BF_WIDTH / 64;
    }

    public int getDimensionY() {

        return BF_HEIGHT / 64;
    }
}
