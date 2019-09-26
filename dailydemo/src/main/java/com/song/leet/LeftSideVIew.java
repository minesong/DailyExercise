package com.song.leet;

import java.util.*;

public class LeftSideVIew {
    public static void main(String[] args) {
        TreeNode node = TreeNode.build();
        LeftSideVIew vIew = new LeftSideVIew();
        List<Integer> r1 = vIew.leftSideView(node);
        System.out.println(r1);
        List<Integer> r2 = vIew.leftSideViewCur(node);
        System.out.println(r2);
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            vIew.leftSideView(node);
        }
        long t2 = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            vIew.leftSideViewCur(node);
        }
        long t3 = System.currentTimeMillis();
        System.out.println(t3 - t2);
        System.out.println(t2 - t1);
    }


    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        leftSideView(root, 0, ret);

        return ret;
    }

    int first = 0;

    public void leftSideView(TreeNode root,
                             int level, List<Integer> ret) {
        if (root == null)
            return;
        if (first == level) {
            first++;
            ret.add(root.val);
        }
        leftSideView(root.left, level + 1, ret);
        leftSideView(root.right, level + 1, ret);
    }

    public List<Integer> leftSideViewCur(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int curNum = 1;
        List<Integer> r = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            curNum--;
            if (cur.right != null) {
                q.offer(cur.right);
            }
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (curNum == 0) {
                r.add(cur.val);
                curNum = q.size();
            }
        }
        return r;
    }

}
