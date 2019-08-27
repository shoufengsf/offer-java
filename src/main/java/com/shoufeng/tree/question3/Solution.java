package com.shoufeng.tree.question3;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * @author shoufeng
 */
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return check(pRoot.left, pRoot.right);
    }

    boolean check(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null) return rightNode == null;
        if (rightNode == null) return false;
        if (rightNode.val != leftNode.val) return false;
        return check(leftNode.right, rightNode.left) && check(leftNode.left, rightNode.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
