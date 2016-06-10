package Lesson_04.kp_02;

import Lesson_01.kp_02.frame_15.rigth_Oleg.Object;

/**
 * Created by Юрий on 10.06.2016.
 */
public class Node {
    private Object o;
    private Node node;

    public Node() {
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }


}
