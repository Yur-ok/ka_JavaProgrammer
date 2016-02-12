package Lesson_01.kp_02.frame_15.wrong_my;

/**
 * Created by Юрий on 11.02.2016.
 */
public class Tank {

    String color;
    int crew;
    int maxSpeed;

    Tank() {
        this("red", 4, 100);
    }

    Tank(String color, int crew, int maxSpeed) {
        this.color = color;
        this.crew = crew;
        this.maxSpeed = maxSpeed;
    }
}
