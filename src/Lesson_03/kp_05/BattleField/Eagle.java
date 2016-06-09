package Lesson_03.kp_05.BattleField;

import java.awt.*;

/**
 * Created by Юрий on 09.06.2016.
 */
public class Eagle implements Drawable, Destroyable {
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
    }

    @Override
    public void destroy() {

    }
}
