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
//        System.out.println(n.obj);

        if (root != null) {
            n.ref = root;
        }
//        System.out.println(n.ref);
        root = n;
//        System.out.println("Root: " + root.obj + " " + root.ref);
        size++;
    }

    public void addLast(Object o) {
        Node n = new Node();
        n.obj = o;
        if (root == null) {
            root = n;
        } else {
            Node last = root;
            Node cp = root;
            while (cp.ref != null) {
//                System.out.println(cp.ref + " " + cp.obj);
                last = cp;
                cp = cp.ref;
            }
            last.ref = n;
        }
        size++;
    }

    public void addAfter(Object o, Object prev) {
        Node prevPoint = null;
        Node cp = root;

        do {
            if (cp.obj == prev) {
                prevPoint = cp;
                break;
            }
            cp = cp.ref;
        } while (cp != null && cp.ref != null);

        if (prevPoint == null) {
            throw new IllegalStateException("List does not contain prev object");
        }
        Node n = new Node();
        n.obj = o;

        if (prevPoint.ref != null) {
            n.ref = prevPoint.ref;
        }
        prevPoint.ref = n;
        size++;
    }

    public int getSize() {
        return size;
    }
}
