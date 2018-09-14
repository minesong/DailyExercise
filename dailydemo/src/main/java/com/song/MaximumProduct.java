package com.song;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/description/
 * 628. Maximum Product of Three Numbers
 */
public class MaximumProduct {
    public static String format(Timestamp time, String format) {
        return time == null ? null : (new SimpleDateFormat(format)).format(time);
    }
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int right = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int left = nums[len - 1] * nums[0] * nums[1];
        return right > left ? right : left;
    }

    public static void main(String[] args) {
        String s = format(new Timestamp(System.currentTimeMillis()), "yyyy-MM-dd HH:mm:ss");
        System.out.println(new MaximumProduct().maximumProduct2(new int[]{-4,-3,-2,-1,60}));
    }

    public int maximumProduct2(int[] nums) {
        int len = nums.length;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int tmp = nums[i];
            if (tmp > max1) {
                max3 = max2;
                max2 = max1;
                max1 = tmp;
            } else if (tmp > max2) {
                max3 = max2;
                max2 = tmp;
            } else if (tmp > max3) {
                max3 = tmp;
            }
            if (tmp < min1) {
                min2 = min1;
                min1 = tmp;
            } else if (tmp < min2) {
                min2 = tmp;
            }
        }
        int right = max1 * max2 * max3;
        int left = max3 * min1 * min2;
        return right > left ? right : left;
    }
}