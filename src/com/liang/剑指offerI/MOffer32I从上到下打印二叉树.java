package com.liang.剑指offerI;

import com.liang.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MOffer32I从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if(root==null)  return new int[0];
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> rsL = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            rsL.add(temp.val);
            if(temp.left!=null) queue.add(temp.left);
            if(temp.right!=null) queue.add(temp.right);
        }
        int[] rs = new int[rsL.size()];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = rsL.get(i);
        }
        return rs;
    }
}
