package Lesson_02.kp_01.frame_03;

/**
 * Created by Юрий on 24.03.2016.
 */
public class Double {

    private int d;
    private Integer integer;
    private Number number;

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public int getD() {

        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public Double() {
        this.number = new Number();
        this.integer = new Integer();

    }
}
