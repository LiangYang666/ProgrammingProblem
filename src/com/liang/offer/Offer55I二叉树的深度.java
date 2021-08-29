package com.liang.offer;

import com.liang.utils.TreeNode;

public class Offer55I二叉树的深度 {

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        else{
            return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        }
    }
}
