package com.song.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HasPathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        sum -= root.val;
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(root, sum, res, temp);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        temp.add(root.val);
        if ((root.left == null) && (root.right == null)) {
            if (sum == 0) {
                res.add(new ArrayList<>(temp));
            }
        }
        dfs(root.left, sum, res, temp);
        dfs(root.right, sum, res, temp);
        temp.remove(temp.size() - 1);
    }


    public int pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int[] total = new int[]{0};

        while (!q.isEmpty()) {
            TreeNode treeNode = q.poll();
            dfs(treeNode, sum, total);
            if (treeNode.left != null) {
                q.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                q.offer(treeNode.
                        right);
            }
        }
        return total[0];

    }

    private void dfs(TreeNode root, int sum, int[] total) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            total[0]++;
        }
        dfs(root.left, sum, total);
        dfs(root.right, sum, total);
    }

    int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }


}
