package com.song.leet;

import java.util.PriorityQueue;

public class KthLargerArray {

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 6, 2, 5, 7, 9, 8, 10};
        int k = 3;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int n : nums) {
            if (queue.size() < k) {
                queue.offer(n);
            } else {
                if (queue.peek() < n) {
                    queue.poll();
                    queue.offer(n);
                }
            }
        }
        System.out.println(queue.peek());
        int l = new KthLargerArray().findKthLargest(nums, k);
        System.out.println(l);
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums == null || nums.length < k) {
            throw new IllegalArgumentException();
        }
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    public int findKthLargest(int[] nums, int start, int end, int k) {

        // 中枢值
        int pivot = nums[start];
        int lo = start;
        int hi = end;

        while (lo < hi) {
            // 将小于中枢值的数移动到数组左边
            while (lo < hi && nums[hi] >= pivot) {
                hi--;
            }

            // 将大于中枢值的数移动到数组右边
            while (lo < hi && nums[lo] <= pivot) {
                lo++;
            }
            if (lo < hi) {
                int t = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = nums[t];
            }
        }
        nums[start] = nums[lo];
        nums[lo] = pivot;

        nums[lo] = pivot;
        int mid = end - lo + 1;
        // 如果已经找到了
        if (mid == k) {
            return pivot;
        }
        // 第k大的数在lo位置的右边
        else if (mid > k) {
            return findKthLargest(nums, lo + 1, end, k);
        }
        // 第k大的数在lo位置的左边
        else {
            // k-(end-lo+1)
            // (end-lo+1)：表示从lo位置开始到end位置的元素个数，就是舍掉右半部分
            // 原来的第k大变成k-(end-lo+1)大
            return findKthLargest(nums, start, lo - 1, k - mid);
        }
    }



}
