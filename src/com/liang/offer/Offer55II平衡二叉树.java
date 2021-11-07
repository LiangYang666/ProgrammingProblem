package com.liang.offer;

import com.liang.utils.TreeNode;

public class Offer55II平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
    int dfs(TreeNode node){
        if(node==null){
            return 1;
        } else {
            int a = dfs(node.left);
            int b = dfs(node.right);
            if(a==-1 || b==-1)  return -1;
            if(Math.abs(a-b)>1) {
                return -1;
            } else {
                return Math.max(a, b)+1;
            }
        }
    }
}
