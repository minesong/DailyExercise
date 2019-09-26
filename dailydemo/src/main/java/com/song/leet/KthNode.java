package com.song.leet;


import java.util.ArrayList;
import java.util.List;

public class KthNode {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(0);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(6);
        new KthNode().KthNode(treeNode, 3);
        System.out.println(list);
    }

    int index = 0;
    static List<TreeNode> list = new ArrayList<>();

    void KthNode(TreeNode root, int k) {
        if (root == null || list.size() >= k) {
            return;
        }
        KthNode(root.left, k);//左边遍历
        list.add(root);
        if (list.size() >= k) {
            return;
        }
        KthNode(root.right, k);//右边遍历
    }
}