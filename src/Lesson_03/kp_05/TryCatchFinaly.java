package Lesson_03.kp_05;

/**
 * Created by Юрий on 19.04.2016.
 */
public class TryCatchFinaly {
    public static void main(String[] args) {

        try {
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("I want to be executed!");
        }
    }
}
