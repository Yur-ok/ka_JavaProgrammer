package Lesson_01.kp_02.frame_15.wrong_my;

/**
 * Created by Юрий on 12.02.2016.
 */
public class ReferencesObjects {
    public static void main(String[] args) {

        Tank t1 = new Tank("red", 0, 0);
        Tank t2 = new Tank("green", 0, 0);
        Tank t3 = new Tank("yellow", 0, 0);
        Tank temp;

        temp = t1;
        t1 = t2;
        t2 = t3;
        t3 = temp;

        System.out.println(t1.color);
        System.out.println(t2.color);
        System.out.println(t3.color);

    }
}
