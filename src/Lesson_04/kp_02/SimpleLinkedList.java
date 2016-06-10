package Lesson_04.kp_02;

/**
 * Created by Юрий on 10.06.2016.
 */
public class SimpleLinkedList {
    private Node root;
    private int size;

    private class Node {
        Object obj;
        Node node;
    }

    public SimpleLinkedList() {
        size = 0;
    }

    public void addFirst(Object o) {
        Node n = new Node();
        n.obj = new Object();
        n.node = getRoot();
        setRoot(n);
    }

    public void addLast(Object o) {

    }

    public void addAfter(Object o, Object prev) {

    }

    public int getSize() {
        return size;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
