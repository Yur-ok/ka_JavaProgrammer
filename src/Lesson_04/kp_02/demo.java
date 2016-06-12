package Lesson_04.kp_02;

/**
 * Created by Юрий on 12.06.2016.
 */
public class demo {
    public static void main(String[] args) {
        SimpleLinkedList sl = new SimpleLinkedList();
        sl.addFirst(new String("one"));
        sl.addFirst(new String("two"));
        sl.addFirst(new String("three"));
//        System.out.println(sl.getSize());
        sl.addLast(new String("Last"));
//        System.out.println(sl.getSize());
    }

}
