package Lesson_04.kp_02;

import java.util.Iterator;

/**
 * Created by Юрий on 16.06.2016.
 */
public class demo {
    public static void main(String[] args) {
        SimpleLinkedList sl = new SimpleLinkedList();

        sl.addFirst("one");
        sl.addLast("two");
        sl.addLast("thee");

        for (Iterator<Object> it = sl.iterator(); it.hasNext(); ) {
            it.next();
            it.remove();
            break;
        }
        sl.printList();
    }
}
