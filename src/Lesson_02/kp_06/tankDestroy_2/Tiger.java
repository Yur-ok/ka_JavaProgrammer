package Lesson_02.kp_06.tankDestroy_2;

/**
 * Created by Юрий on 27.02.2016.
 */
public class Tiger extends Tank {

    private int armor;

    public Tiger(ActionField af, BattleField bf) {
        super(af, bf);
        armor = 1;
    }

    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        armor = 1;
    }
}
