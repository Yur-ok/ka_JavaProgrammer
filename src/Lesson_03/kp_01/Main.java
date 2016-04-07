package Lesson_03.kp_01;

/**
 * Created by Юрий on 07.04.2016.
 */

public class Main {
    public static void main(String[] args) {

        try {
            Main.print("1 1");
        } catch (MyExcept e) {
            e.printStackTrace();
        } finally {
            System.out.println("NoCatchFound");
        }

        try {
            Main.print("1");
        } catch (MyExcept e) {
            e.myPersonalException();
        }
    }

    public static void print(String s) {
        System.out.println(s);
        if (s.equals("1")) {
            throw new MyExcept();
        }
    }

    public static void doSome() throws InterruptedException {
        Thread.sleep(1000);
    }


}
