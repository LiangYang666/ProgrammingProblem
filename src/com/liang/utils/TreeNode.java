package com.liang.utils;

import java.util.ArrayList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    public TreeNode(int _val,TreeNode _left,TreeNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public TreeNode(String input){
        // input example: input=[4,1,5,#,#,2]
        String[] split = input.substring(1, input.length() - 1).split(",");
        val = Integer.parseInt(split[0]);
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(this);
        int i = 1;
        while (i < split.length) {
            ArrayList<TreeNode> temp = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                TreeNode node = list.get(j);
                if (node == null) {
                    continue;
                }
                if (i < split.length) {
                    if (!split[i].equals("#")) {
                        node.left = new TreeNode(Integer.parseInt(split[i]));
                    }
                    temp.add(node.left);
                    i++;
                }
                if (i < split.length) {
                    if (!split[i].equals("#")) {
                        node.right = new TreeNode(Integer.parseInt(split[i]));
                    }
                    temp.add(node.right);
                    i++;
                }
            }
            list = temp;
        }


    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public String printTreeAllNodes(){
        // 层序遍历打印所有
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(this);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (!list.isEmpty()){
            ArrayList<TreeNode> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                TreeNode node = list.get(i);
                if (node==null){
                    sb.append("#,");
                    continue;
                }
                sb.append(node.val).append(",");
                temp.add(node.left);
                temp.add(node.right);
            }
            list = temp;
        }
        sb.append(']');
        return sb.toString();
    }
}

