package com.song.leet;


public class LCA {
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || q == null || p == null)
            return null;
        if (root.val > Math.max(q.val, p.val))
            return lowestCommonAncestor2(root.left, p, q);
        if (root.val < Math.min(q.val, p.val))
            return lowestCommonAncestor2(root.right, p, q);
        return root;

    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || null == p || null == q) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode cur = root;
        while (true) {
            if (q.val > cur.val && p.val > cur.val) {
                cur = cur.right;
            } else if (q.val < cur.val && p.val < cur.val) {
                cur = cur.left;
            } else {
                return cur;
            }

        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || root == q || root == p) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;

    }

}
