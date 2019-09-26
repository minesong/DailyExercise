package com.song.leet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeOrder {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.build();
        TreeOrder order = new TreeOrder();
        List<Integer> r1 = order.preorderTraversal(treeNode);
        System.out.println(r1);
        r1 = order.postorderTraversal(treeNode);
        System.out.println(r1);

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);

            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.addFirst(curr.val);
            if (curr.left != null) {
                stack.push(curr.left);

            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        return list;
    }

}
