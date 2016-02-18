package Lesson_01.kp_04.frame_02;

/**
 * Created by Юрий on 12.02.2016.
 */
public class BattleField {

    public String[][] getBattleField() {
        return battleField;
    }

    public void setBattleField(String[][] battleField) {
        this.battleField = battleField;
    }

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

    private int amountOfBriks;

    public int getAmountOfBriks() {
        return amountOfBriks;
    }

    public void setAmountOfBriks(int amountOfBriks) {
        this.amountOfBriks = amountOfBriks;
    }

    public void numbersOFBriks() {
        int count = 0;
        for (int i = 0; i <= battleField.length - 1; i++) {
            for (int j = 0; j <= battleField[i].length - 1; j++) {
                if (battleField[i][j].equals("B")) {
                    count++;
                }
            }
        }
        System.out.println(count);
        setAmountOfBriks(count);
    }

    public String getQuadrantXY(int v, int h) {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }





}
