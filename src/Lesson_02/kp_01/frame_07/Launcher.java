package Lesson_02.kp_01.frame_07;

/**
 * Created by Юрий on 12.02.2016.
 */
public class Launcher {
    public static void main(String[] args) throws Exception {

        T34 t34 = new T34();
        Tiger tiger = new Tiger();
        BT7 bt7 = new BT7();
        Tank t = new Tank();

//        t34.setColor("Green");
//        t34.setCrew(3);
//        tiger.setColor("Yellow");
//        tiger.setCrew(2);
//        bt7.setColor("Red");
//        bt7.setCrew(1);
//        System.out.println("T34 info: \n" + "Color: " + t34.getColor() + "\nCrew: " + t34.getCrew());
//        System.out.println("BT7info: \n" + "Color: " + bt7.getColor() + "\nCrew: " + bt7.getCrew());
//        System.out.println("Tiger info: \n" + "Color: " + tiger.getColor() + "\nCrew: " + tiger.getCrew());

        System.out.println(t34.toString());
        t34.move();
        System.out.println(bt7.toString());
        bt7.move();
        System.out.println(tiger.toString());
        tiger.move();
        System.out.println(t.toString());
        t.move();
    }
}
