package com.liang.utils;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    public TreeNode(int _val,TreeNode _left,TreeNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

