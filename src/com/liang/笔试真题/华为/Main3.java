package com.liang.笔试真题.华为;

import java.util.*;

public class Main3 {
    static HashMap<String, Integer> count = new HashMap<>();
    static List<String> ans = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.trim();
        s = s.substring(1, s.length()-1);
        System.out.println(s);
        String[] arrs = s.split(",");
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arrs[0]));
        queue.addLast(root);
        for (int i = 1; i < arrs.length; i+=2) {
            TreeNode temp = queue.removeFirst();
            if (temp==null){
                queue.addLast(null);
                queue.addLast(null);
                continue;
            } else {
                if (arrs[i].equals("null")){
                    temp.left = null;
                } else {
                    temp.left = new TreeNode(Integer.parseInt(arrs[i]));
                }
                if (arrs[i+1].equals("null")){
                    temp.right = null;
                } else {
                    temp.right = new TreeNode(Integer.parseInt(arrs[i+1]));
                }
                queue.addLast(temp.left);
                queue.addLast(temp.right);
            }
        }
        String collect = collect(root);

//        System.out.println(ans);
//        System.out.println(count);
//        System.out.println(count.size());


        System.out.println("["+ans.get(ans.size()-1)+"]");




    }
    public static String collect(TreeNode node){
        if (node==null) return "null";
        String serial = node.val+","+collect(node.left)+","+collect(node.right);
        count.put(serial, count.getOrDefault(serial, 0)+1);
        if (count.get(serial)==2){
            ans.add(serial);
        }
//        System.out.println(serial);
        return serial;
    }
}
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
