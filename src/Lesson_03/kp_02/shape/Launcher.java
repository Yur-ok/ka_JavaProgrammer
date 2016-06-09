package Lesson_03.kp_02.shape;

/**
 * Created by Юрий on 07.04.2016.
 */
public class Launcher {
    public static void main(String[] args) {

        Shape[] shapesss = {new Circle(), new Triangle(), new Rectangle()};
        new ShapesTemplate(shapesss);

    }
}
