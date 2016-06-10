package Lesson_04.kp_01;

/**
 * Created by Юрий on 09.06.2016.
 */
public class Student {
    private String name;
    private String secondName;

    public Student(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) { //проверяем тип объекта, который мы получили. Если объект другого типа (false) если объект null будет тоже (false).
            Student s = (Student) obj;
            if (name != null && name.equals(s.getName()) &&
                    secondName != null && secondName.equals(s.getSecondName())) {
                return true;
            }
        }
        return false;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
