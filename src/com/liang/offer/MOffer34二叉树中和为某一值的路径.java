package com.liang.offer;

import com.liang.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MOffer34二叉树中和为某一值的路径 {
    static
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ArrayList<List<Integer>> rs = new ArrayList<>();
        if(root==null)
            return rs;
        dp(rs, root, new ArrayList<>(), target, 0);
        return rs;
    }
    static
    public void dp(ArrayList<List<Integer>> rs, TreeNode root, ArrayList<Integer> temp, int target, int now){
        temp.add(root.val);
        now += root.val;
        if(root.left==null && root.right==null){
            if(now==target){
                rs.add(new ArrayList<>(temp));
            }
        } else {
            if(root.left!=null){
                dp(rs, root.left, temp, target, now);
            }
            if(root.right!=null){
                dp(rs, root.right, temp, target, now);
            }
        }
        temp.remove(temp.size()-1);;
    }
}
