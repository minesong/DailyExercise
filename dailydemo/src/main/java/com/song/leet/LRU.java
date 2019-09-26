package com.song.leet;


import java.util.*;

class CacheNode {
    int key;
    int value;
    CacheNode next;
    CacheNode pre;

    @Override
    public String toString() {
        return "{key=" + key + ",value=" + value + "}";
    }
}

public class LRU {
    private Map<Integer, CacheNode> cache;
    private int maxSize;
    private CacheNode head;
    private CacheNode tail;
    private int count;

    public LRU(int maxSize) {
        if (maxSize <= 0) {
            throw new RuntimeException();
        }
        cache = new HashMap<>();
        head = new CacheNode();
        tail = new CacheNode();
        head.next = tail;
        tail.pre = head;
        this.maxSize = maxSize;
    }

    public void save(int key, int value) {
        CacheNode node = cache.get(key);
        if (null == node) {
            node = new CacheNode();
            node.value = value;
            node.key = key;
            addHead(node);
            count++;
            cache.put(key, node);
            if (count > maxSize) {
                removeTail();
                cache.remove(key);
                count--;
            }
            return;
        }
        node.value = value;
        removeToHead(node);
    }

    public int get(int key) {
        CacheNode v = cache.get(key);
        if (null == v) {
            throw new NullPointerException();
        }
        removeToHead(v);
        return v.value;
    }

    private void removeNode(CacheNode node) {
        if (null == node) {
            throw new NullPointerException();
        }
        CacheNode pre = node.pre;
        CacheNode next = node.next;
        pre.next = next;
        next.pre = pre;
        node.next = null;
        node.pre = null;
    }

    private void removeToHead(CacheNode node) {
        removeNode(node);
        addHead(node);
    }

    private void addHead(CacheNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void removeTail() {
        if (tail == head) {
            throw new RuntimeException();
        }
        CacheNode del = tail.pre;
        CacheNode pre = tail.pre.pre;
        pre.next = tail;
        tail.pre = pre;
        del.next = null;
        del.pre = null;

    }

    public void print() {
        System.out.println("---start---");

        if (head.next == tail) {
            System.out.println("{}");
            System.out.println("---end---");
            return;
        }
        CacheNode node = head.next;
        while (node != tail) {
            if (tail.pre == node) {
                System.out.print(node);
            } else {
                System.out.print(node + ".next=");
            }
            node = node.next;
        }
        node = tail.pre;
        System.out.println();
        while (node != head) {
            if (head.next == node) {
                System.out.print(node);
            } else {
                System.out.print(node + ".pre=");

            }
            node = node.pre;
        }
        System.out.println("---end---");
        System.out.println();

    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.print();
        lru.save(1, 2);
        lru.print();
        lru.save(1, 3);
        lru.print();
        lru.save(2, 2);
        lru.print();
        lru.save(3, 3);
        lru.print();
        lru.save(4, 4);
        lru.save(3, 5);
        lru.print();
        lru.save(2, 7);
        lru.print();
    }


}
