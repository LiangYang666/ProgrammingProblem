package com.liang.utils;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public BinaryTree() {
    }

    public TreeNode createTree(String s) {
        int end = s.lastIndexOf("]");
        int start = s.indexOf("[");
        s = s.substring(start+1, end);
        if (s.equals(""))   return null;
        String[] all = s.split(",");
        if(all.length==0)   return null;
        int i = 0;
        Queue<TreeNode> parents = new LinkedList<>();
        String get = all[i++].trim();
        if(get.equals("null"))  return null;
        TreeNode head = new TreeNode(Integer.parseInt(get));
        parents.add(head);
        while(i<all.length){
            get = all[i++].trim();
            TreeNode temp = parents.remove();
            if (!get.equals("null")) {
                temp.left = new TreeNode(Integer.parseInt(get));
                parents.add(temp.left);
            }
            if(i==all.length) break;
            get = all[i++].trim();
            if (!get.equals("null")) {
                temp.right = new TreeNode(Integer.parseInt(get));
                parents.add(temp.right);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode tree = binaryTree.createTree("[3,5,1,63,2,0,8,null,null,7,4]");
        binaryTree.dp(tree);
    }
    void dp(TreeNode root){
        if(root!=null){
            System.out.println(root.val);
            dp(root.left);
            dp(root.right);
        }
    }
}
