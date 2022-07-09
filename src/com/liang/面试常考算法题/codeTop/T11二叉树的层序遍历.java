package com.liang.面试常考算法题.codeTop;

import com.liang.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T11二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        List<List<Integer>> rs = new ArrayList<>();
        if (root==null) return rs;
        nodes.addLast(root);
        while (!nodes.isEmpty()){
            int length = nodes.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode node = nodes.removeFirst();
                temp.add(node.val);
                if (node.left != null) {
                    nodes.addLast(node.left);
                }
                if (node.right != null) {
                    nodes.addLast(node.right);
                }
            }
            rs.add(temp);
        }
        return rs;
    }
}
