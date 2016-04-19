package Lesson_03.kp_05;

/**
 * Created by Юрий on 19.04.2016.
 */
public class TryCatchFinaly2 {
    public static void main(String[] args) {

        catcher();
        System.out.println("Done");
    }

    public static void catcher() {
        try {
            throw new Exception();
        } catch (Exception e) {
            throw new IllegalStateException();
        } finally {
            System.out.println("I want to be printed!");
        }
    }

}
