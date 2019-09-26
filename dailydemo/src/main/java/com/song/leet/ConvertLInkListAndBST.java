package com.song.leet;

import java.util.*;

public class ConvertLInkListAndBST {

    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (null == pRootOfTree) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRootOfTree;
        TreeNode real = null;
        TreeNode pre = null;
        boolean isFirst = true;
        while (null != node || !stack.isEmpty()) {
            while (null != node) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (isFirst) {
                isFirst = false;
                real = node;
                node.left = null;
                pre = node;
            } else {
                pre.right = node;
                node.left = pre;
                pre = node;
            }
            node = node.right;
        }
        return real;
    }

    TreeNode real = null;
    TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (null == pRootOfTree) {
            return null;
        }
        inorder(pRootOfTree);
        return real;
    }

    private void inorder(TreeNode root) {
        if (null == root) {
            return;
        }
        inorder(root.left);
        if (null == real) {
            real = root;
            head = root;
            real.left = null;
        } else {
            head.right = root;
            root.left = head;
            head = root;
        }
        inorder(root.right);
    }

    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }

    private TreeNode helper(ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        //初始化快慢指针
        ListNode slow = head, fast = head;
        ListNode slowPre = null;
        while (fast != null && fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //注意断链
        slowPre.next = null;
        //慢指针指向中点节点
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head);
        root.right = helper(slow.next);
        return root;
    }

    public int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // 记录字符上次出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        // 最近出现重复字符的位置
        int pre = -1;

        for (int i = 0, strLen = str.length(); i < strLen; i++) {
            Character ch = str.charAt(i);
            Integer index = map.get(ch);
            if (index != null)
                pre = Math.max(pre, index);
            max = Math.max(max, i - pre);
            map.put(ch, i);
        }

        return max;
    }
}
