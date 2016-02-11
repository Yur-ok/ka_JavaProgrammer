package Lesson_01.kp_01;

/**
 * Created by Юрий on 10.02.2016.
 */
public class GreetingService_1_1_5 {
    public static void main(String[] args) {

//        System.out.println(args.length);

        if (args.length > 0) {
            System.out.print("Hello ");
            for (int i = 0; i <= args.length - 1; i++) {
                if (i == args.length - 1) {
                    System.out.println(args[i]);
                } else {
                    System.out.print(args[i] + " ");
                }
            }
        } else {
            System.out.println("Type one parameter after class name! \nExample:\njava GreetingService_1_1_5 [some text]");
        }
    }
}
