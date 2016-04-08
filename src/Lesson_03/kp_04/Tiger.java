package Lesson_03.kp_04;

import java.awt.*;

/**
 * Created by Юрий on 27.02.2016.
 */
public class Tiger extends AbstractTank {

    private int armor;

    public Tiger(ActionField af, BattleField bf) {
        super(af, bf);
        armor = 1;
        tankColor = new Color(255, 40, 0);
        gunColor = new Color(34, 255, 18);
    }

    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        armor = 1;
        tankColor = new Color(255, 40, 0);
        gunColor = new Color(34, 255, 18);
    }

    @Override
    public void destroy() {
        if (armor > 0) {
            armor--;
        } else {
            super.destroy();
        }
    }
}
