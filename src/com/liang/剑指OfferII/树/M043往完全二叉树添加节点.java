package com.liang.剑指OfferII.树;

import com.liang.utils.TreeNode;

import java.util.LinkedList;

public class M043往完全二叉树添加节点 {
}
class CBTInserter {
    private TreeNode root;
    private LinkedList<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        getFistNull(root);

    }
    private void getFistNull(TreeNode root){
        queue.add(root);
        while (true){
            TreeNode temp = queue.getFirst();
            if (temp.left!=null && temp.right!=null){
                queue.poll();
                queue.add(temp.left);
                queue.add(temp.right);
            } else {
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                break;
            }
        }
    }

    public int insert(int v) {
        TreeNode temp = queue.getFirst();
        if(temp.left==null){
            temp.left = new TreeNode(v);
            queue.add(temp.left);
        } else {
            temp.right = new TreeNode(v);
            queue.poll();
            queue.add(temp.right);
        }
        return temp.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
