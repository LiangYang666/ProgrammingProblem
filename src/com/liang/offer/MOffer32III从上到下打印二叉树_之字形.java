package com.liang.offer;

import com.liang.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MOffer32III从上到下打印二叉树_之字形 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        int n = 1;
        int i = 0;
        List<List<Integer>> rs = new ArrayList<>();
        ArrayList<Integer> tempRs = new ArrayList<>();
        if(root==null)  return rs;
        while(!treeNodes.isEmpty()){
            TreeNode temp;
            temp = treeNodes.poll();
            n -= 1;
            if(i%2==0)
                tempRs.add(temp.val);
            else
                tempRs.add(0, temp.val);
            if(temp.left!=null){
                treeNodes.add(temp.left);
            }
            if(temp.right!=null){
                treeNodes.add(temp.right);
            }
            if(n==0){
                n = treeNodes.size();
                i++;
                rs.add(tempRs);
                tempRs = new ArrayList<>();
            }
        }
        return rs;
    }
}
