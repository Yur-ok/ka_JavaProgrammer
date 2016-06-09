package Lesson_03.kp_05.BattleField;

/**
 * Created by Юрий on 27.02.2016.
 */
public class BT7 extends AbstractTank {

    public BT7(ActionField af, BattleField bf) {
        super(af, bf);
        speed = 5;
    }

    public BT7(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        speed = 5;
    }
}
