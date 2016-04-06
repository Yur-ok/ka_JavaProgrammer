package Lesson_02.kp_06.tankTigerArmor_3;

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

    @Override
    public void destroy() {
        if (armor > 0) {
            armor--;
        } else if (armor == 0) {
            x = -100;
            y = -100;
        }
    }
}
