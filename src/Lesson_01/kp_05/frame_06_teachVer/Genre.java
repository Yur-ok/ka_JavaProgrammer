package Lesson_01.kp_05.frame_06_teachVer;

/**
 * Created by Юрий on 18.02.2016.
 */
public enum Genre {
    COMPUTERS(0), FANTASY(1), FOOD(2), FICTION(3), HISTORY(4);

    private int id;

    Genre(int i) {
        this.id = i;
    }

    public int getId() {
        return id;
    }
}
