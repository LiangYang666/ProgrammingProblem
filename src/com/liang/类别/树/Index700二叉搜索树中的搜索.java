package com.liang.类别.树;


import com.liang.utils.TreeNode;

public class Index700二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        while (true){
            if(node==null)  return null;
            if(node.val==val){
                return node;
            } else if(node.val<val){
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }
}
