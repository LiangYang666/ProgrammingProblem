package com.liang.类别.树;

import com.liang.utils.TreeNode;

public class Index563二叉树的坡度 {
    int all;
    public int findTilt(TreeNode root) {
        dfs(root);
        return all;
    }
    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        int last_val = node.val;
        node.val = Math.abs(l-r);
        all+= node.val;
        return l+r+last_val;
    }
}
