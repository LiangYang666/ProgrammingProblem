package com.liang.笔试真题.微软.yl;

import java.util.*;
class TreeNode {
    public int value;
    public List<TreeNode> nodes;

    public TreeNode(int v){
        value = v;
        nodes = new ArrayList<>();
    }
}
public class Main3 {
    public static void main(String[] args) {
//        int[] A = {0, 1, 1};
//        int[] B = {1, 2, 3};
        int[] A = {1, 1, 1, 9, 9, 9, 9, 7, 8};
        int[] B = {2, 0, 3, 1, 6, 5, 4, 0 ,0};

        System.out.println(new Main3().solution(A, B));
    }
    boolean[] visit;
    int N;
    int rs = 0;
    public int solution(int[] A, int[] B) {
        // write your code in Java 8 (Java SE 8)
        N  = A.length;
        visit = new boolean[N];
        TreeNode root = getNodes(0, A, B);
        getPeople(root);
        return rs;
    }

    public int getPeople(TreeNode node){
        int people = 1;
        for (int i = 0; i < node.nodes.size(); i++) {
            int tt = getPeople(node.nodes.get(i));
            people += tt;
            rs += tt/5;
            if (tt%5!=0)    rs++;
        }
        return people;
    }
    public TreeNode getNodes(int start, int[] A, int[] B){
        TreeNode node = new TreeNode(start);
        for (int i = 0; i < N; i++) {
            if (visit[i])   continue;
            if (A[i]==start){
                visit[i] = true;
                node.nodes.add(getNodes(B[i], A, B));
            } else if (B[i]==start){
                visit[i] = true;
                node.nodes.add(getNodes(A[i], A, B));
            }
        }
        return node;
    }

}

/*
//        int[][] conjs = new int[N][2];
//        for (int i = 0; i < N; i++) {
//            if (A[i]<B[i]){
//                conjs[i][0] = A[i];
//                conjs[i][1] = B[i];
//            } else {
//                conjs[i][1] = A[i];
//                conjs[i][0] = B[i];
//            }
//        }
//        Arrays.sort(conjs, (o1, o2) -> {
//            if (o1[0]==o2[0]){
//                return o1[1]-o2[1];
//            }
//            return o1[0]-o2[0];
//        });
//        System.out.println(Arrays.deepToString(conjs));
 */