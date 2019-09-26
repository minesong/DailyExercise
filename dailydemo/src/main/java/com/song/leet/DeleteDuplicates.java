package com.song.leet;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class DeleteDuplicates {
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while (next != null) {
            if (pre.val == next.val) {
                next = next.next;
                pre.next = next;
            } else {
                next = next.next;
                pre = pre.next;

            }
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {

            }
        }
        return head;
    }


    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length < 2) {
            return 0;
        }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            } else {
                return 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            } else {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }
        }
        return -1;

    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(Math.abs(nums[i] - nums[i - 1]), max);
        }
        return max;
    }

    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] > nums[l]) {
                l = m + 1;
            } else {
                h = m;
            }
        }

        return nums[h];
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int retVal;
        retVal = max[0] = min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], Math.max(nums[i] * max[i - 1], nums[i] * min[i - 1]));
            min[i] = Math.min(nums[i], Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]));
            retVal = Math.max(retVal, max[i]);
        }

        return retVal;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = Math.max(nums[i], nums[i] + dp[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println();
        int r = new DeleteDuplicates().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(r);

    }

}