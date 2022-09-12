package com.liang.笔试真题.蔚来.zhj;

import com.liang.utils.TreeNode;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
//        new TreeNode()

        // input {5,3,6,2,4,#,#,1}
//        TreeNode root = new TreeNode("[4,1,5,#,3,#,#,2]");
//        TreeNode root = new TreeNode("[4,3,5,2,#,#,6,1,#,#,7]");
        TreeNode root = new TreeNode("[5,3,6,2,4,#,#,1]");
        for (TreeNode treeNode : new Main2().balanceSubTree(root)) {
            System.out.println(treeNode.printTreeAllNodes());
        }
    }

    public ArrayList<TreeNode> balanceSubTree(TreeNode root){
        ArrayList<TreeNode> res = new ArrayList<>();
        dfs(root, res);
        res.add(root);
        return res;
    }
    public int dfs(TreeNode node, ArrayList<TreeNode> res){
        if (node==null){
            return 0;
        }
        int l = dfs(node.left, res);
        int r = dfs(node.right, res);
        if (Math.abs(l-r)>1){
            if (l>1){
                if (node.left!=null){
                    res.add(node.left);
                }
                node.left = null;
                l = 0;
            }
            if (r>1){
                if (node.right != null) {
                    res.add(node.right);
                }
                node.right = null;
                r = 0;
            }
        }
        return Math.max(l, r)+1;
    }
}
