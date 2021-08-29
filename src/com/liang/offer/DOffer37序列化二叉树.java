package com.liang.offer;

import com.liang.utils.BinaryTree;
import com.liang.utils.TreeNode;

import java.util.*;

public class DOffer37序列化二叉树 {

    public static void main(String[] args) {
        String a = "[1,2,3,null,null,4,5]";
        BinaryTree binaryTree = new BinaryTree();
        TreeNode tree = binaryTree.createTree("[3,5,1,63,2,0,8,null,null,7,4]");
        Codec codec = new Codec();
        tree = codec.deserialize("[3,5,1,63,2,0,8,null,null,7,4]");
        System.out.println(codec.serialize(tree));
    }
}
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "[]";
        }
        StringBuilder rs = new StringBuilder("[");
        Queue<TreeNode> treeNodes = new ArrayDeque<TreeNode>();
        rs.append(root.val).append(",");
        treeNodes.add(root);
        while(!treeNodes.isEmpty()){
            TreeNode node = treeNodes.poll();
//            System.out.println(node.val);
            if(node.left==null){
                rs.append("null").append(",");
            } else {
                rs.append(node.left.val).append(",");
                treeNodes.add(node.left);
            }
            if(node.right==null){
                rs.append("null").append(",");
            } else {
                rs.append(node.right.val).append(",");
                treeNodes.add(node.right);
            }
        }
        rs.append("]");
        return rs.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int begin = data.indexOf("[")+1;
        int end = data.lastIndexOf("]")-1;
        if(end<begin)   return null;
        data = String.copyValueOf(data.toCharArray(), begin, end-begin+1);
        String[] elements = data.split(",");
        if(elements[0].trim().equals("null"))  return null;
        TreeNode head = new TreeNode(Integer.parseInt(elements[0]));
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(head);
        for (int i = 1; i < elements.length; i++) {
            String element;
            TreeNode node = treeNodes.pop();
            element = elements[i].trim();
            if(!element.equals("null")){
                node.left = new TreeNode(Integer.parseInt(element));
                treeNodes.add(node.left);
            }
            if(++i== elements.length)  break;
            element = elements[i].trim();
            if(!element.equals("null")){
                node.right = new TreeNode(Integer.parseInt(element));
                treeNodes.add(node.right);
            }
        }
        return head;
    }
}
