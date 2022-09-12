package com.liang.normal;


import com.liang.utils.BinaryTree;
import com.liang.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MIndex863二叉树中所有距离为K的结点 {
    int N=501;
    int[] first = new int[N];
    int[] to = new int[N*3];
    int[] next = new int[N*3];
    boolean[] visit = new boolean[N];
    int index = 0;
    int target;

    void add(int a, int b){ //sava a to b
        next[index] = first[a];
        to[index] = b;
        first[a] = index;
        index++;
    }
    void addUndirected(int a, int b){//sava a and b
        add(a, b);
        add(b, a);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Arrays.fill(first, -1);
        dpCreateGraph(root);
        this.target = target.val;
        List<Integer> rs = new ArrayList<Integer>();

        if(k==0) {
            rs.add(target.val);
            return rs;
        }
        bfsSearchK(rs, target.val, 0, k);
        return rs;
    }
    void getAllEdgeOfN(int n){
        int index=first[n];
        while (index!=-1) {
            System.out.println(n+" --> "+to[index]);
            index=next[index];
        }
    }

    void bfsSearchK(List<Integer> rs, int number,int kn, int k){
        ArrayList<Integer> layer = new ArrayList<>();

        visit[number] = true;
        int index = first[number];
        while (index!=-1) {
            if(!visit[to[index]])   layer.add(to[index]);
            index = next[index];
        }
        kn++;
        if(kn==k){
            rs.addAll(layer);
        } else {
            for (int n : layer) {
                bfsSearchK(rs,  n, kn, k);
            }
        }
    }
    void dpCreateGraph(TreeNode temp){
        if(temp!=null){
            if(temp.left!=null){
                addUndirected(temp.val, temp.left.val);
            }
            if(temp.right!=null){
                addUndirected(temp.val, temp.right.val);
            }
            dpCreateGraph(temp.left);
            dpCreateGraph(temp.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        String[] s = {"[]", "[3,5,1,6,2,0,8,null,null,7,4]", "[3,5]", "[0,1,null,null,2,null,3,null,4]" };
        TreeNode tree = binaryTree.createTree(s[1]);
        MIndex863二叉树中所有距离为K的结点 code = new MIndex863二叉树中所有距离为K的结点();
        System.out.println(code.distanceK(tree, new TreeNode(5), 2).toString());
    }
}

