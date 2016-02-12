package Lesson_01.kp_02.frame_04;

/**
 * Created by Юрий on 11.02.2016.
 */
public class PrintTankInfo {

    static void printTankInfo() {
        Tank t = new Tank();
        System.out.println("Tank_1_2_9 information:\nColor = " + t.color);
        System.out.println("Crew equal = " + t.crew);
        System.out.println("Max speed equal = " + t.maxSpeed);
    }

    public static void main(String[] args) {
        printTankInfo();
    }
}
