package Lesson_04.kp_01;

/**
 * Created by Юрий on 10.06.2016.
 */
public class Demo {
    public static void main(String[] args) {

        ClassRoom cr = new ClassRoom();
        Student ivan = new Student("Ivan", "Ivanov");
        Student petr = new Student("Petr", "Sidorov");
        Student roman = new Student("Roman", "Romanov");

        cr.enter(ivan);
        cr.enter(petr);
        cr.enter(roman);
        cr.printStudentInfo();
        cr.getStudentsCount();
        cr.isPresent(petr);
        cr.leave(petr);
        cr.printStudentInfo();
        cr.getStudentsCount();
        cr.isPresent(petr);

    }
}
