package com.liang.面试常考算法题.codeTop;

import com.liang.utils.TreeNode;

public class T30二叉树中的最大路径和 {
    int rs = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return rs;
    }

    public int dfs(TreeNode root) {
        if (root==null){
            return -10000;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        int temp = max(new int[] {root.val, l, r, root.val+l+r, root.val+l, root.val+r});
        if (temp>rs){
            rs = temp;
        }
        return root.val + max(new int[]{0, l, r});
    }

    public int max(int[] nums){
        int rs = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > rs) {
                rs = num;
            }
        }
        return rs;
    }
}
