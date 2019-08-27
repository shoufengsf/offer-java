package com.shoufeng.tree.question1;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author shoufeng
 */
public class Solution {

    //前序遍历：中节点->左节点->右节点 中序遍历：左节点->中节点->右节点
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        int midNodeValue = pre[0];
        TreeNode treeNode = new TreeNode(midNodeValue);
        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == midNodeValue) {
                index = i;
            }
        }
        int[] leftIn = new int[index];
        for (int i = 0; i < index; i++) {
            leftIn[i] = in[i];
        }
        int[] rightIn = new int[in.length - index - 1];
        for (int i = index + 1; i < in.length; i++) {
            rightIn[i - index - 1] = in[i];
        }
        int[] leftPre = new int[index];
        for (int i = 0; i < index; i++) {
            leftPre[i] = pre[i + 1];
        }
        int[] rightPre = new int[pre.length - index - 1];
        for (int i = index + 1; i < pre.length; i++) {
            rightPre[i - index - 1] = pre[i];
        }
        treeNode.left = reConstructBinaryTree(leftPre, leftIn);
        treeNode.right = reConstructBinaryTree(rightPre, rightIn);
        return treeNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
