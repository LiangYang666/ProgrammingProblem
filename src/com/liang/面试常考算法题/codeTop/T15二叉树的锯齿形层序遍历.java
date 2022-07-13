package com.liang.面试常考算法题.codeTop;

import com.liang.utils.TreeNode;

import java.util.*;

public class T15二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        if (root==null) return rs;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.addLast(root);
        ArrayList<Integer> temp = new ArrayList<>();
        int k=0;
        while (!nodes.isEmpty()){
            int n = nodes.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = nodes.removeFirst();
                temp.add(node.val);
                if (node.left!=null){
                    nodes.addLast(node.left);
                }
                if (node.right!=null){
                    nodes.addLast(node.right);
                }
            }
            if (k++%2==1){
                Collections.reverse(temp);
            }
            rs.add(temp);
            temp = new ArrayList<>();
        }
        return rs;
    }
}
