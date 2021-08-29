package com.liang.offer;

import com.liang.utils.TreeNode;

public class Offer28对称二叉树 {
    static
    public boolean isSymmetric(TreeNode root) {
        if(root==null)  return true;
        return dp(root.left, root.right);

    }

    static boolean dp(TreeNode A, TreeNode B){
        if(A==null && B==null)  return true;
        else if(A==null || B==null) return false;
        else {
            if(A.val==B.val){
                return dp(A.left, B.right) && dp(A.right, B.left);
            } else {
                return false;
            }
        }
    }
}
