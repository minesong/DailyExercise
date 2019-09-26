package com.song.leet;


import java.util.List;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0, nums.length - 1, nums);
    }

    private TreeNode dfs(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = dfs(start, mid - 1, nums);
        treeNode.right = dfs(mid + 1, end, nums);
        return treeNode;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }

    private TreeNode helper(ListNode head) {
        if (head == null) return null;
        if (head.next == null){
            return new TreeNode(head.val);
        }
        //初始化快慢指针
        ListNode slow = head, fast = head;
        ListNode slowPre = null;
        while (fast != null && fast.next != null) {
            slowPre =slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowPre.next = null;
        //慢指针指向中点节点
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head);
        root.right = helper(slow.next);
        return root;
    }

}
