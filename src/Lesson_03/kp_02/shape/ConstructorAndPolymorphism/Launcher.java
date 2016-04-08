package Lesson_03.kp_02.shape.ConstructorAndPolymorphism;

/**
 * Created by Юрий on 08.04.2016.
 */
public class Launcher {
    public static void main(String[] args) {
        Glyph glyph = new RoundGlyph(10);
        glyph.draw();
        Glyph glyph1 = new Descender();
    }
}
