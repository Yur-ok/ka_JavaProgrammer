package Lesson_04.kp_02;

/**
 * Created by Юрий on 10.06.2016.
 */
public class SimpleLinkedList {
    private Node root;
    private int size;

    private class Node {
        Object obj;
        Node ref;
    }

    public SimpleLinkedList() {
        size = 0;
    }

    public void addFirst(Object o) {
        Node n = new Node();
        n.obj = o;

        if (root != null) {
            n.ref = root;
        }
        root = n;
        size++;
    }

    public void addLast(Object o) {

        Node n = new Node();
        n.obj = o;
        size++;
    }

    public void addAfter(Object o, Object prev) {

    }

    public int getSize() {
        return size;
    }
}
