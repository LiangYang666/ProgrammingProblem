package com.liang.面试常考算法题.codeTop;

import com.liang.utils.TreeNode;

public class T18二叉树的最近公公祖先 {
    TreeNode rs;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return rs;
    }
    public int dfs(TreeNode root, TreeNode p, TreeNode q){
        int n = 0;
        if (root == null){
            return 0;
        }
        if (root.val==p.val || root.val==q.val){
            n++;
        }
        n += dfs(root.left, p, q)+dfs(root.right, p, q);
        if (n==2 && rs==null)   rs = root;
        return n;
    }
}
