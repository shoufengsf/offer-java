package com.shoufeng.tree.question2;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author shoufeng
 */
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        //有右子树，则返回右子树最左节点
        TreeLinkNode leftNode = pNode.right;
        if (leftNode != null) {
            while (leftNode.left != null) {
                leftNode = leftNode.left;
            }
            return leftNode;
        }
        while (pNode.next != null) {
            //如果父节点的左节点是当前节点 则下一个节点是父节点
            if (pNode.next.left == pNode) return pNode.next;
            pNode = pNode.next;
        }
        return pNode.next;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
