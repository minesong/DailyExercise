package com.song.leet;

import java.util.*;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode node = root.left;
        //只有右子树 stack 可能为空
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}
