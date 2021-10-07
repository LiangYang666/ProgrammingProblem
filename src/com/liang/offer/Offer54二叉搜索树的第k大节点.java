package com.liang.offer;

import com.liang.utils.TreeNode;

import java.util.LinkedList;

public class Offer54二叉搜索树的第k大节点 {
    LinkedList<Integer> top_k = new LinkedList<>();

    public int kthLargest(TreeNode root, int k) {   //传统中序遍历
        if (root != null) {
            kthLargest(root.left, k);
            top_k.addLast(root.val);
            if (top_k.size() > k) {
                top_k.removeFirst();
            }
            kthLargest(root.right, k);
        }
        if (top_k.size() > 0)
            return top_k.getFirst();
        else
            return 0;
    }
    int k,rs;
    public int kthLargest1(TreeNode root, int k) {  //中序遍历的倒序
        this.k = k;
        dfs(root);
        return rs;
    }
    void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.right);
        k--;
        if(k==0) {
            rs = root.val;
        }
        dfs(root.left);
    }
}
