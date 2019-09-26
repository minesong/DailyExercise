package com.song.testng.test;

import com.google.common.collect.Lists;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TLTest {


    static final Lock lock = new ReentrantLock();
    static final Condition condition = lock.newCondition();

    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("done");
            }
        });


        Thread thread1 = new Thread(() -> {
            System.out.println(1);
            try {
                System.out.println(1 + "_" + barrier.await());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                System.out.println(e);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);

                try {
                    Thread.sleep(100);
                    System.out.println(2 + "_" + barrier.await());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    System.out.println(e);
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(3);
                try {
                    System.out.println(3 + "_" + barrier.await());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    System.out.println(e);
                }
            }
        });


    }
}


