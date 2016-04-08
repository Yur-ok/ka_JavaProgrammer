package Lesson_03.kp_04;

import java.awt.*;

/**
 * Created by Юрий on 27.02.2016.
 */
public class T34 extends AbstractTank {

    public T34(ActionField af, BattleField bf) {
        super(af, bf, 64, 512, Direction.UP);
        tankColor = new Color(34, 255, 18);
        gunColor = new Color(255, 40, 0);
    }

    public T34(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        tankColor = new Color(34, 255, 18);
        gunColor = new Color(255, 40, 0);
    }
}
