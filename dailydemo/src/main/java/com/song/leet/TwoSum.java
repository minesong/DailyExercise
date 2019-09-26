package com.song.leet;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int r = target - nums[i];
            Integer v = map.get(r);
            if (null != v && v != i) {
                return new int[]{i, v};
            }

        }
        return new int[0];
    }
}
