package com.liang.offer;

import com.liang.utils.TreeNode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class MOffer07重建二叉树 {

    static
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        ArrayList<Integer> b = (ArrayList<Integer>) Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return dp(preorder, 0, preorder.length-1, b, 0, b.size()-1);
    }
    static public TreeNode dp(int[] preorder, int i, int j, ArrayList<Integer> inorder, int m, int n){
        if(i>j) return null;
        TreeNode now = new TreeNode(preorder[i]);
        int indexInorder = inorder.indexOf(now.val);
        int lLength = indexInorder-m;
        int rLength = n-indexInorder;
        now.left = dp(preorder, i+1, i+1+lLength-1, inorder, m, indexInorder-1);
        now.right = dp(preorder, i+1+lLength-1+1, j, inorder, indexInorder+1, n);
        return now;
    }

}

