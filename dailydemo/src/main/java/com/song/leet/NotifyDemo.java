package com.song.leet;


import com.sun.org.apache.bcel.internal.generic.IFNULL;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyDemo {


    final ReentrantLock lock = new ReentrantLock();

    private final Condition notEmpty = lock.newCondition();

    private final Condition notFull = lock.newCondition();

    private final List<Integer> res = new ArrayList<>();

    private final int max = 5;

    public void offer(int num) {
        try {
            lock.lock();
            while (max == res.size()) {
                notFull.await();
            }
            res.add(num);
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public Integer take() {
        try {
            lock.lock();
            while (0 == res.size()) {
                notEmpty.await();
            }
            int ram = new Random().nextInt(res.size());
            Integer r = res.get(ram);
            res.remove(ram);
            notFull.signal();
            return r;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 使用快慢指针查找中间结点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next.next;
            // 让slow少走一步，排序均匀
            if (fast == null)
                break;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        right = sortList(right);

        return mergeTwoLists(left, right);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val <= l2.val) {
            res = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        } else {
            res = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }
        return res;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (null == root) {

            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(root, sum, res, tmp);
        return res;

    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> tmp) {
        if (null == root) {
            if (sum == 0) {

            }
            return;
        }
        tmp.add(root.val);
        if (sum - root.val == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(tmp));
        }
        dfs(root.left, sum - root.val, res, tmp);
        dfs(root.right, sum - root.val, res, tmp);
        tmp.remove(tmp.size() - 1);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        List<Integer> tmp = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int cur = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            tmp.add(node.val);
            cur--;
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
            if (cur == 0) {
                res.add(new ArrayList<>(tmp));
                tmp.clear();
                cur = q.size();
            }
        }
        return res;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (null == head) {
            return null;
        }
        if (m == n) {
            return head;
        }
        int i = 1;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        while (i < m) {
            if (i == m - 1) {
                pre = cur;
            }
            cur = cur.next;
            i++;
        }
        pre.next = null;
        ListNode r1 = cur;
        while (i < n) {
            cur = cur.next;
            i++;
        }
        ListNode r2 = cur;
        ListNode r2Next = cur.next;
        ListNode dummy = new ListNode(0);
        ListNode t = null;
        while (r1 != r2) {
            if (null == dummy.next) {
                t = r1;
            }
            cur = r1.next;
            r1.next = dummy.next;
            dummy.next = r1;
            r1 = cur;
        }
        r1.next = dummy.next;
        dummy.next = r1;
        pre.next = dummy.next;
        t.next = r2Next;
        return m == 1 ? pre.next : head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new NotifyDemo().reverseBetween(head, 2, 4);
    }
}
