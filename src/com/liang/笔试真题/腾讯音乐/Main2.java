package com.liang.笔试真题.腾讯音乐;

import com.liang.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main2 main2 = new Main2();
        int[] a = {1,1,2};
        ArrayList<Integer> aL = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            aL.add(a[i]);
        }
        int[] b ={1,2,1};

        ArrayList<Integer> bL = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            bL.add(b[i]);
        }
        main2.getBinaryTrees(aL, bL);

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param preOrder int整型ArrayList
     * @param inOrder int整型ArrayList
     * @return TreeNode类ArrayList
     */
    public ArrayList<TreeNode> getBinaryTrees (ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        // write code here
        return dp(preOrder, 0, preOrder.size()-1, inOrder, 0, inOrder.size()-1);
    }
    public ArrayList<TreeNode> dp(ArrayList<Integer> a, int i, int j, ArrayList<Integer> b, int m, int n){
        ArrayList<TreeNode> nodes = new ArrayList<>();
        if (i>j){
            nodes.add(null);
            return nodes;
        }
        int v = a.get(i);
        for (int k = m; k <= n; k++) {
            if (v ==b.get(k)){
                int lLength = k-m;
                ArrayList<TreeNode> nodes1 = dp(a, i + 1, i + 1 + lLength - 1, b, m, k - 1);
                ArrayList<TreeNode> nodes2 = dp(a, i + 1 + lLength, j, b, k + 1, n);
                for (int l = 0; l < nodes1.size(); l++) {
                    for (int o = 0; o < nodes2.size(); o++) {
                        TreeNode treeNode = new TreeNode(v);
                        treeNode.left = nodes1.get(l);
                        treeNode.right = nodes2.get(o);
                        nodes.add(treeNode);
                    }
                }
            }
        }
        return nodes;
    }
}
