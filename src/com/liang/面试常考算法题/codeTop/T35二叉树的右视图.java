package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;
import com.liang.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T35二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> rs = new ArrayList<>();
        if (root==null) return rs;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.addLast(root);
        while (!nodes.isEmpty()){
            int n = nodes.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = nodes.removeFirst();
                if (i==n-1){
                    rs.add(node.val);
                }
                if (node.left!=null)    nodes.addLast(node.left);
                if (node.right!=null)    nodes.addLast(node.right);
            }
        }
        return rs;
    }


    public List<Integer> rightSideView1(TreeNode root) {
        ArrayList<Integer> rs = new ArrayList<>();
        if (root==null) return rs;
        int[] have = new int[100];
        Arrays.fill(have, Integer.MIN_VALUE);
        dfs(root, have, 0);
        for (int i = 0; i < have.length&&have[i]!=Integer.MIN_VALUE; i++) {
            rs.add(have[i]);
        }
        return rs;
    }
    public void dfs(TreeNode root, int[] have, int deep){
        if (root==null) return;
        if (have[deep]==Integer.MIN_VALUE){
            have[deep] = root.val;
        }
        dfs(root.right, have, deep+1);
        dfs(root.left, have, deep+1);
    }

}
