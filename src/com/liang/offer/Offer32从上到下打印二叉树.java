package com.liang.offer;

import com.liang.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Offer32从上到下打印二叉树 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        if(root==null) return rs;
        treeNodes.add(root);
        int j = 1;
        List<Integer> each;
        each = new ArrayList<>();
        while(!treeNodes.isEmpty()) {
            TreeNode temp = treeNodes.remove();
            each.add(temp.val);
            if (temp.left != null)  treeNodes.add(temp.left);
            if(temp.right!=null) treeNodes.add(temp.right);
            if (--j==0){
                j = treeNodes.size();
                rs.add(each);
                each = new ArrayList<>();
            }
        }
        return rs;
    }
}
