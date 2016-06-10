package Lesson_04.kp_01;

import java.util.ArrayList;

/**
 * Created by Юрий on 10.06.2016.
 */
public class Demo {
    public static void main(String[] args) {

        ClassRoom cr = new ClassRoom();
        cr.students = new ArrayList<>();
        cr.enter(new Student("Ivan", "Ivanov"));
        cr.enter(new Student("Petr", "Sidorov"));
        cr.enter(new Student("Roman", "Romanov"));
        cr.printStudentInfo();
        cr.getStudentsCount();
        cr.isPresent("Petr", "Sidorov");
        cr.leave("Petr", "Sidorov");
        cr.printStudentInfo();
        cr.getStudentsCount();
        cr.isPresent("Petr", "Sidorov");
    }
}
