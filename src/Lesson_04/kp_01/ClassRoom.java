package Lesson_04.kp_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юрий on 09.06.2016.
 */
class ClassRoom extends Student {

    private List<Student> students;

    public ClassRoom() {
        students = new ArrayList<>();
    }
    public void enter(Student student) {
        students.add(student);
    }

    public void leave(Student student) {
        if (students.contains(student)) {
            students.remove(student);
        }
    }
//    public void leave(String name, String secondName) {
//        int idx = 0;
//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).getName().equals(name) && students.get(i).getSecondName().equals(secondName)) {
//                idx = i;
//            }
//        }
//        System.out.println("Students \"" + students.get(idx).getName() + " " + students.get(idx).getSecondName() + "\"" +
//                " leave ClassRoom.");
//        students.remove(idx);
//    }

    public void getStudentsCount() {
        System.out.println(students.size());
    }

    public void isPresent(Student student) {
        boolean isHere = false;
        if (students.contains(student)) {
            isHere = true;
        }
        if (isHere) {
            System.out.println("Yes.");
        } else {
            System.out.println("No.");
        }
    }
//    public void isPresent(String name, String secondName) {
//        boolean isHere = false;
//        for (Student s : students) {
//            if (s.getName().equals(name) && s.getSecondName().equals(secondName)) {
//                isHere = true;
//            }
//        }
//        if (isHere) {
//            System.out.println("Yes.");
//        } else {
//            System.out.println("No.");
//        }
//    }

    public void printStudentInfo() {
        for (Student s : students) {
            System.out.println(s.getName() + " " + s.getSecondName());
//            System.out.println(s);
        }
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

}
