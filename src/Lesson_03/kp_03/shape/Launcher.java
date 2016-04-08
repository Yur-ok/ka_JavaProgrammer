package Lesson_03.kp_03.shape;

/**
 * Created by Юрий on 07.04.2016.
 */
public class Launcher {
    public static void main(String[] args) {

        Drawable[] shapesss = {new Circle(), new Triangle(), new Rectangle(), new Square()};
        new ShapesTemplate(shapesss);

    }
}
