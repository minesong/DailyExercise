package com.song.leet;

import com.alibaba.fastjson.JSON;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "{" + val + "}";
    }

    public static TreeNode build() {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(3);
        node.left = new TreeNode(2);
        node.right.left = new TreeNode(5);
        node.left.left = new TreeNode(6);
        node.left.left.right = new TreeNode(7);
        node.left.left.right.right = new TreeNode(9);
        node.left.left.right.right.right = new TreeNode(11);
        node.left.left.right.left = new TreeNode(8);
        return node;
    }
}
