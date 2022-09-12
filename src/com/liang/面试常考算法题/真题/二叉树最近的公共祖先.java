package com.liang.面试常考算法题.真题;

import com.liang.utils.TreeNode;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试常考算法题.真题
 * @ClassName: 二叉树最近的公共祖先
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/4/26 14:59
 * @Version: 1.0
 */
public class 二叉树最近的公共祖先 {
    static TreeNode rs;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return rs;
    }
    static
    int dfs(TreeNode root, TreeNode p, TreeNode q){
        if (rs!=null)   return 2;
        int temp = 0;
        temp = Math.max(dfs(root.left, p, q), dfs(root.right, p, q))+1;
        if (root==p || root==q){
            temp++;
        }
        if (temp==2){
            rs = root;
        }
        return temp;
    }
}
