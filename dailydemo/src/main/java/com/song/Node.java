package com.song;

public class Node {
    private Integer val;

    private Node next;


    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(Integer val) {
        this.val = val;
    }
}
