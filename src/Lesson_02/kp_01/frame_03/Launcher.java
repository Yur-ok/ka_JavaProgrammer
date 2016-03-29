package Lesson_02.kp_01.frame_03;

/**
 * Created by Юрий on 27.02.2016.
 */
public class Launcher {
    public static void main(String[] args) {
        DoubleExt dExt = new DoubleExt();
        System.out.println();

        dExt.setN(5);
        dExt.setI(9);

        System.out.println(dExt.getI());
        System.out.println(dExt.getN());

        Double d = new Double();

        d.getNumber().setN(55);
        d.getInteger().setI(44);

        System.out.println(d.getInteger().getI());
        System.out.println(d.getNumber().getN());
    }
}
