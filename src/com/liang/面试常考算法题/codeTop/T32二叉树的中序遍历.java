package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;
import com.liang.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T32二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> rs = new ArrayList<>();
        dfs(root, rs);
        return rs;
    }
    public void dfs(TreeNode root, List<Integer> rs) {
        if (root == null) return;
        dfs(root.left, rs);
        rs.add(root.val);
        dfs(root.right, rs);
    }
}
