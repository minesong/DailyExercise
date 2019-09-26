package com.song.leet;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        List<GarbageCollectorMXBean> l = ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean b : l) {
            System.out.println(JSON.toJSON(b.getName()));
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
        final int[] i = {0};
        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                latch1.countDown();
                System.out.println(list.get(i[0]));
                i[0]++;
                latch2.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch2.await();
                    System.out.println(list.get(i[0]));
                    i[0]++;
                    latch1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(" "));

    }


    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int m = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            int c = 1;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (set.add(s.charAt(j))) {
                    c++;
                    continue;
                }
                break;
            }
            m = Math.max(c, m);
        }
        return m;
    }
}
