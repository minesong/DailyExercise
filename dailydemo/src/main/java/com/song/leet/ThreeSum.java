package com.song.leet;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(2, false);
        Boolean r = Optional.ofNullable(map).map(m -> m.get(1)).orElse(false);
        System.out.println(r);

        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }


    class P {
        int a;
        int b;

        public P(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        Map<Integer, List<P>> map1 = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<P> list;
                if ((list = map1.get(nums[i] + nums[j])) == null) {
                    list = new ArrayList<>();
                    map1.put(nums[i] + nums[j], list);
                }
                list.add(new P(i, j));
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<P> ms = map1.get(-nums[i]);
            if (null != ms) {
                for (P s : ms) {
                    if (s.a != i && s.b != i && set.add(getKey(nums[s.a], nums[s.b], nums[i]))) {

                        List<Integer> l = new ArrayList<>();
                        r.add(l);
                        l.add(nums[s.a]);
                        l.add(nums[s.b]);
                        l.add(nums[i]);
                    }
                }
            }
        }
        return r;
    }

    String getKey(int a, int b, int c) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        if (a < c) {
            int t = a;
            a = c;
            c = t;
        }
        if (b < c) {
            int t = b;
            b = c;
            c = t;
        }
        return a + "" + b + "" + c;
    }


}
