package Lesson_03.kp_05.BattleField;

import java.awt.*;

/**
 * Created by Юрий on 09.06.2016.
 */
public class Rock implements Drawable, Destroyable {
    @Override
    public void destroy() {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
    }
}
