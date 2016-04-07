package Lesson_03.kp_02.shape;

/**
 * Created by Юрий on 07.04.2016.
 */
public class Launcher {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Artist artist = new Artist();

        artist.create(shape);
        artist.create(new Circle());
        artist.create(new Triangle());
        artist.create(new Rectangle());
    }
}
