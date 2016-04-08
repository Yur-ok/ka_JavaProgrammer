package Lesson_03.kp_02.shape.ConstructorAndPolymorphism;

/**
 * Created by Юрий on 08.04.2016.
 */
public class RoundGlyph extends Glyph {

    private int radius = 5;

    public RoundGlyph(int radius) {
        System.out.println("RoundGlyph#Constr");
        draw();
        this.radius = radius;
    }

    @Override
    protected void draw() {
        System.out.println("RoundGlyph#Draw");
        System.out.println("RoundGlyph#Radius " + radius);
    }
}
