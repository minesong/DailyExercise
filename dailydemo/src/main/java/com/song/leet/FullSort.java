package com.song.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FullSort {
    List<List<Character>> lists = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        String s = "abcfdassssssssssssssssssssssssssssss";
        List<String> list = new ArrayList<>();
        while (true) {
            Thread.sleep(1);
            list.add(s.intern());
        }
//        int t = 3;
//        int[] arr = {1, 1, 1, 2};
//        Arrays.sort(arr);
//        //  fullSort(arr, 0, arr.length - 1);
//        ToTarget(arr, 0, t);
    }

    static List<Integer> list = new ArrayList<>();

    public static void fullSort(int[] arr, int start, int end) {
        // 递归终止条件
        if (start == end) {
            for (int i : arr) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, i, start);
            fullSort(arr, start + 1, end);
            swap(arr, i, start);
        }
    }


    public static void ToTarget(int[] arr, int start, int target) {
        // 递归终止条件
        if (target == 0) {
            System.out.println(list);
            // return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }
            if (target < 0) {
                return;
            }
            if (target - arr[i] < 0) {
                return;
            }
            list.add(arr[i]);
            //i变为i+1就是不能s重复数字
            ToTarget(arr, 0, target - arr[i]);
            list.remove(list.size() - 1);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
