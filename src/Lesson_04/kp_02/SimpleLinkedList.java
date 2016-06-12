package Lesson_04.kp_02;

import Lesson_01.kp_02.frame_15.rigth_Oleg.Object;

import java.util.Iterator;

/**
 * Created by Юрий on 10.06.2016.
 */
public class SimpleLinkedList implements Iterable {
    private Node root;
    private int size;

    @Override
    public Iterator iterator() {
        return (Iterator) new SLLItetator();
    }

    private class Node {
        Object obj;
        Node ref;
    }

    private class SLLItetator {
        public Object next() {
            return root.obj;
        }

        public boolean hasNext() {
            if (root.ref != null) {
                return true;
            }
            return false;
        }
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
            cp.ref = n;
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

    public void printList() {
        if (size == 0) {
            System.out.println("List is empty");
        }
        System.out.print("{");
        Node cp = root;
        while (cp.ref != null) {
            System.out.print(cp.obj + ", ");
            cp = cp.ref;
        }
        System.out.print(cp.obj);
        System.out.println("}");
    }
}
