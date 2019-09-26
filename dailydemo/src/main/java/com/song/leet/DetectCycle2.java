package com.song.leet;

import jdk.nashorn.internal.ir.IfNode;
import org.apache.poi.ss.formula.functions.T;

import java.util.*;

public class DetectCycle2 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode t = head;
        int i = 0;
        while (t != null) {
            if (!set.add(t)) {
                return t;
            }
            t = t.next;
        }
        return null;
    }

    ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;

        for (int i = 1; i < m; i++)
            pre = pre.next;
        ListNode cur = pre.next;
        for (int i = m; i < n; i++) {
            ListNode t = cur.next;
            cur.next = t.next;
            t.next = pre.next;
            pre.next = t;
        }
        return dummy.next;
    }


    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cur = 1;
        int level = 0;
        while (!q.isEmpty()) {
            TreeNode t = q.poll();

            cur--;

            if (t.left != null) {
                q.offer(t.left);
            }
            if (t.right != null) {
                q.offer(t.right);
            }
            if (cur == 0) {
                level++;
                cur = q.size();
            }
            if (t.left == null || t.right == null){
                return level;
            }
        }
        return 0;
    }


}
