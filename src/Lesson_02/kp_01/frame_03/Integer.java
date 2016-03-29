package Lesson_02.kp_01.frame_03;

/**
 * Created by Юрий on 24.03.2016.
 */
public class Integer {

    private int i;
    private Number number;

    public Integer() {
        this.number = new Number();
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void printName() {
        System.out.printf("Integer");
    }
}
