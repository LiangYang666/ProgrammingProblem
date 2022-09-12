package com.liang.笔试真题.腾讯音乐;

import com.liang.utils.TreeNode;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    public int getTreeSum (TreeNode tree) {
        // write code here
        int mod = (int) (1e9+7);
        return (int) (dfs(tree)%mod);

    }
    public long dfs(TreeNode node){
        if (node.left==null){
            return 1;
        }
        long l = dfs(node.left);
        long r = dfs(node.right);
        return Math.max(l, r)*2+1;
    }
}
