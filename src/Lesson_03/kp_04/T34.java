package Lesson_03.kp_04;

/**
 * Created by Юрий on 27.02.2016.
 */
public class T34 extends AbstractTank {

    public T34(ActionField af, BattleField bf) {
        super(af, bf, 64, 512, Direction.UP);
    }

    public T34(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
    }
}
