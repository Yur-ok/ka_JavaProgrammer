package Lesson_02.kp_06.tankDestroy_2;

/**
 * Created by Юрий on 27.02.2016.
 */
public class BT7 extends Tank {

    public BT7(ActionField af, BattleField bf) {
        super(af, bf);
        speed = 5;
    }

    public BT7(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        speed = 5;
    }
}
