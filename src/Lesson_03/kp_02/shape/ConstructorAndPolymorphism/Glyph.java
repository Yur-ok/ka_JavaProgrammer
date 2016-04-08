package Lesson_03.kp_02.shape.ConstructorAndPolymorphism;

/**
 * Created by Юрий on 08.04.2016.
 */
public class Glyph {
    public Glyph() {
        System.out.println("Glyph#Constr");
        draw();
    }

    protected void draw() {
        System.out.println("Glyph#Draw");
    }
}
