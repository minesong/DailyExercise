package com.song.leet;

import jdk.nashorn.internal.ir.IfNode;

import java.util.*;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (null == coins || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);

            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    public int change2(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) { // don't use coins at index i - 1
                    dp[i][j] = dp[i - 1][j];
                } else { // use and don't use at index i
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }

    HashMap<Integer, Integer> memory = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {

        if (nums == null || nums.length == 0 || target < 0)
            return 0;
        return dfs(nums, target, 0);
    }

    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0 || amount < 0)
            return 0;
        return dfs(coins, amount, 0);

    }

    int dfs(int[] nums, int target, int level) {
        int count = 0;
        if (target == 0)
            return 1;
        if (target < 0) {
            return 0;
        }
        if (memory.containsKey(target))
            return memory.get(target);
        for (int i = level; i < nums.length; i++) {
            count += dfs(nums, target - nums[i], i + 1);
        }
        memory.put(target, count);
        return count;
    }

    public int change4(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public int change3(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];

                }
            }
        }
        return dp[amount];
    }

    Integer min = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode root) {
        if (null == root) {
            return;
        }
        inorder(root.left);
        if (null != pre) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        new CoinChange().coinChange(new int[]{2}, 3);
        List<Long> longs = new ArrayList<>();
       boolean r= longs.stream().noneMatch(l->l.equals(1L));
        System.out.println(r);
    }
}
