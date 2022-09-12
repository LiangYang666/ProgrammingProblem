package com.liang.类别.树;

import com.liang.utils.TreeNode;

public class Index235二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val>q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        int pVal = p.val;
        int qVal = q.val;
        while (true){
            if(root.val<pVal){
                root = root.right;
            } else if(root.val>qVal){
                root = root.left;
            }else {
                return root;
            }
        }

    }
}
