package com.song.leet;

import java.util.*;
import java.util.zip.Inflater;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    sum++;
                    bfs(i, j, grid);
                }
            }
        }
        return sum;
    }

    private void bfs(int si, int sj, char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{si, sj});
        grid[si][sj] = '2';
        while (!q.isEmpty()) {
            int[] ij = q.poll();
            int i = ij[0];
            int j = ij[1];
            if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                q.offer(new int[]{i + 1, j});
                grid[i + 1][j] = '2';
            }
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                q.offer(new int[]{i - 1, j});
                grid[i - 1][j] = '2';
            }
            if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                q.offer(new int[]{i, j + 1});
                grid[i][j + 1] = '2';
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                q.offer(new int[]{i, j - 1});
                grid[i][j - 1] = '2';
            }
        }
    }

    private void dfs(int si, int sj, char[][] grid) {
        if (si < 0 || sj < 0 || si >= grid.length || sj >= grid[0].length) {
            return;
        }
        if (grid[si][sj] != '1') {
            return;
        }
        grid[si][sj] = '2';
        dfs(si + 1, sj, grid);
        dfs(si - 1, sj, grid);
        dfs(si, sj + 1, grid);
        dfs(si, sj - 1, grid);
    }

    public boolean exist(char[][] grid, String word) {

        if (null == word || word.length() == 0 ||
                null == grid || grid.length == 0 || grid[0].length == 0) {
            return false;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    dfsExist(i, j, grid, word, 0);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return res;
    }

    boolean res = false;

    private void dfsExist(int si, int sj, char[][] grid, String word, int index) {
        if (index == word.length()) {
            res = true;
            return;
        }
        if (res || si < 0 || sj < 0 || si >= grid.length || sj >= grid[0].length) {
            return;
        }
        char t = grid[si][sj];
        if (word.charAt(index) == grid[si][sj]) {
            grid[si][sj] = '*';
            dfsExist(si + 1, sj, grid, word, index + 1);
            dfsExist(si - 1, sj, grid, word, index + 1);
            dfsExist(si, sj + 1, grid, word, index + 1);
            dfsExist(si, sj - 1, grid, word, index + 1);
            grid[si][sj] = t;
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, 0, res, new ArrayList<>());
        return res;

    }

    private <E> void subsets(int[] nums, int cur, List<List<Integer>> res, List<Integer> tmp) {
        if (cur <= nums.length) {
            res.add(new ArrayList<>(tmp));

        }
        Set<Integer> set = new HashSet<>();
        for (int i = cur; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                continue;
            }
            tmp.add(nums[i]);
            subsets(nums, i + 1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int r = new NumberOfIsland().rob(new int[]{2, 7, 9, 3, 1});
    }

    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        if (x <= 3) {
            return 1;
        }
        int l = 1;
        int h = x / 2 + 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            int r = x / m;
            if (r == m) {
                return r;
            } else if (r > m) {
                l = m + 1;
            } else
                h = m - 1;
        }
        return l;

    }

    public int rob(int[] nums) {
        int len = 0;
        if (null == nums || 0 == (len = nums.length)) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // Build largest number from sorted array.
        boolean r = true;
        StringBuilder largestNumberStr = new StringBuilder();
        for (String numAsStr : asStrs) {
            //去掉前导0
            if (r && numAsStr.equals("0")) {
                continue;
            }
            r = false;
            largestNumberStr.append(numAsStr);
        }

        return largestNumberStr.length() == 0 ? "0" : largestNumberStr.toString();
    }

    public int majorityElement(int[] nums) {
        int r = nums[0];
        int t = 0;
        for (int i = 1; i < nums.length; i++) {
            if (r != nums[i]) {
                t--;
            } else {
                t++;
            }
            if (t < 0) {
                r = nums[i];
                t = 1;
            }
        }
        return r;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;

    }
}
