package com.song.leet;

import java.util.*;

public class removeInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList();
        Set<String> visited = new HashSet();
        q.add(s);

        List<String> result = new ArrayList();
        boolean found = false;
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (is_valid(curr)) {
                result.add(curr);
                found = true;
            }

            if (!found) {
                next(q, visited, curr);
            }
        }

        return result;
    }

    void next(Queue<String> q, Set<String> visited, String s) {
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String n = s.substring(0, i) + s.substring(i + 1);
                if (!visited.contains(n)) {
                    q.add(n);
                    visited.add(n);
                }
            }
        }
    }

    boolean is_valid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++count;
            } else if (c == ')') {
                --count;
                if (count == -1) return false;
            }
        }

        return count == 0;
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //j * (i - j)两个数乘积
                //拆分成多个
                int tmpMax = Math.max(j * (i - j), dp[i - j] * j);

                dp[i] = Math.max(dp[i], tmpMax);
            }
        }
        return dp[n];
    }

    public int integerReplacement(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == r) {
            return 32;
        }
        dfs(n, 0);
        return r;
    }

    int r = Integer.MAX_VALUE;

    private void dfs(int n, int t) {
        if (n == 1) {
            r = Math.min(r, t);
            return;
        }
        if (n < 1) {
            return;
        }

        if ((n % 2) == 0) {
            dfs(n / 2, t + 1);
        } else {
            dfs(n - 1, t + 1);
            dfs(n + 1, t + 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true){
            list.add("");
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<Integer>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else j++;
        }
        int[] r = new int[res.size()];
        i = 0;
        for (int s : res) {
            r[i++] = s;
        }
        return r;
    }
}
