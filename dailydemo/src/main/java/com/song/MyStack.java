package com.song;

public class MyStack {
    private Node head;

    public MyStack() {
        head = new Node(0);
    }

    public void push(Integer val) {
        if (null == val) {
            throw new NullPointerException("val must not be null");
        }
        Node insertNode = new Node(val);
        insertNode.setNext(head.getNext());
        head.setNext(insertNode);

    }

    public boolean isEmpty() {
        return head.getNext() == null;
    }

    public Integer getHeadVal() {
        if (head.getNext() == null) {
            return null;
        }
        return head.getNext().getVal();
    }

    public Node remove() {
        if (null == head.getNext()) {
            return null;
        }
        Node rNode = head.getNext();
        head.setNext(rNode.getNext());
        rNode.setNext(null);
        return rNode;
    }

}
