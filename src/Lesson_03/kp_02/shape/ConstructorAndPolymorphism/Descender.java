package Lesson_03.kp_02.shape.ConstructorAndPolymorphism;

/**
 * Created by Юрий on 08.04.2016.
 */
public class Descender extends Glyph {


    private String s;

    public Descender() {
    }

    @Override
    protected void draw() {
        System.out.println("Descender#Draw");
        System.out.println(s.length());
    }
}
