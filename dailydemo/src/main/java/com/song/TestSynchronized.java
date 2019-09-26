package com.song;

import java.util.HashMap;
import java.util.Map;

public class TestSynchronized {
    public void test1() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    System.out.println(1);
                }
            }
        }

    }

    public synchronized void test2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                System.out.println(1);
            }
        }
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1",null);
        System.out.println(map.containsKey("1"));
        final TestSynchronized myt2 = new TestSynchronized();
        Thread test1 = new Thread(new Runnable() {
            public void run() {
                myt2.test1();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            public void run() {
                myt2.test2();
            }
        }, "test2");
        test2.interrupt();
        test1.start();
        test2.start();

    }

}
