package Lesson_01.kp_02.frame_15.rigth_Oleg;

/**
 * Created by Юрий on 12.02.2016.
 */
public class Object {

    private String name;
    private Object ref;

    public Object(String name) {
        this.name = name;
    }

    public Object getRef() {
        return ref;
    }

    public void setRef(Object ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void printRef() {
        System.out.println(name + " >> " + ref.getName());
    }
}
