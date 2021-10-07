package com.liang.offer;

import com.liang.utils.TreeNode;

import java.util.LinkedList;

public class Offer54二叉搜索树的第k大节点 {
    LinkedList<Integer> top_k =new LinkedList<>();
    public int kthLargest(TreeNode root, int k) {
        if(root!=null){
            kthLargest(root.left, k);
            top_k.addLast(root.val);
            if (top_k.size()>k){
                top_k.removeFirst();
            }
            kthLargest(root.right, k);
        }
        if(top_k.size()>0)
            return top_k.getFirst();
        else
            return 0;
    }
}
