package Lesson_02.kp_05;

/**
 * Created by Юрий on 12.02.2016.
 */
public class BattleField {

    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;

    private String[][] battleField = {
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
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
}
