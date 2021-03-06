package Lesson_04.kp_02;

import java.util.Iterator;

/**
 * Created by Юрий on 10.06.2016.
 */
public class SimpleLinkedList implements Iterable<Object> {
    private Node root;
    private int size;

    @Override
    public Iterator<Object> iterator() {
        return new SLLItetator();
    }

    private class Node {
        Object obj;
        Node ref;
    }

    private class SLLItetator implements Iterator<Object> {
        private Node prev;
        private Node cp;

        public SLLItetator() {

        }

        @Override
        public void remove() {
            if (!hasNext() && prev == null) {
                //only one element
                cp = null;
                root = null;
            } else if (!hasNext() && prev != null) {
                //last element
                prev.ref = null;
                cp = null;
            } else if (hasNext() && prev == null) {
                //first element
                root = cp.ref;
                cp = root;
            } else {
                //middle element
                prev.ref = cp.ref;
                cp = cp.ref;
            }
            size--;
        }

        @Override
        public Object next() {
            if (cp == null && root != null) {
                cp = root;
                return cp.obj;
            }
            if (hasNext()) {
                prev = cp;
                cp = cp.ref;
                return cp.obj;
            }
            throw new IllegalStateException("list has no more elements");
        }

        @Override
        public boolean hasNext() {
            return (cp == null && root != null) || (cp != null && cp.ref != null);
        }
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
