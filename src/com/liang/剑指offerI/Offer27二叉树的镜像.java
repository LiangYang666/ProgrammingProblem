package com.liang.剑指offerI;

import com.liang.utils.TreeNode;

public class Offer27二叉树的镜像 {
    static

    public TreeNode mirrorTree(TreeNode root) {
        dp(root);
        return root;
    }
    static void dp(TreeNode root){
        if(root==null)  return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dp(root.left);
        dp(root.right);
    }



}
