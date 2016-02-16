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

    private final boolean COLORDED_MODE = false;
    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;

}
