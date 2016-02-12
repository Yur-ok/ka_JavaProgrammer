package Lesson_01.kp_02.frame_15.rigth_Oleg;

/**
 * Created by Юрий on 12.02.2016.
 */
public class launcher {
    public static void main(String[] args) {

        Object ref1 = new Object("ref1");
        Object ref2 = new Object("ref2");
        Object ref3 = new Object("ref3");

        ref1.setRef(ref2);
        ref2.setRef(ref3);
        ref3.setRef(ref1);

        ref1.printRef();
        ref2.printRef();
        ref3.printRef();
    }
}
