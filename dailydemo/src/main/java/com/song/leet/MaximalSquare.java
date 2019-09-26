package com.song.leet;

import javax.swing.text.EditorKit;
import java.util.*;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] - '0';
                if (dp[i][j] == 1) {
                    if (max < 1) max = 1;
                    if (i - 1 < 0 || j - 1 < 0) continue;
                    //各个路径最小1的个数
                    int temp = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]);
                    dp[i][j] = temp + 1;
                    max = Math.max(max, dp[i][j]);
                }

            }
        return max * max;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return ret;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int begin = i + 1;
            int end = len - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum == 0) {
                    ret.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                    begin++;
                    end--;
                    while (begin < end && nums[begin] == nums[begin - 1])
                        begin++;
                    while (begin < end && nums[end] == nums[end + 1])
                        end--;

                } else if (sum > 0)
                    end--;
                else
                    begin++;

            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = new MaximalSquare().getPermutation(9, 362880);
        System.out.println(s);

    }

    public String getPermutation(int n, int k) {
        int arr[] = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        fullSort(arr, 0, n - 1, k);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.size());
        return list.get(k - 1);


    }

    List<String> list = new ArrayList<>();

    public void fullSort(int[] arr, int start, int end, int k) {

        if (start == end) {
            k--;
            String t = "";
            for (int i = 0; i < arr.length; i++) {
                t += arr[i];
            }
            list.add(t);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, i, start);
            fullSort(arr, start + 1, end, k);
            swap(arr, i, start);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
