package com.liang.leetcode.周赛;

import java.util.ArrayList;
import java.util.HashSet;

public class Z230514_345_6434统计完全连通分量的数量 {

    public int countCompleteComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            unionFind.union(edges[i][0], edges[i][1]);
        }
        int rs = 0;
        for (int i = 0; i < n; i++) {
            int ri = unionFind.find(i);
            if (ri!=i){
                // 仅统计头节点 以防重复
                continue;
            }
            int a = unionFind.pointCount[ri];
            int b = unionFind.edgeCount[ri];
            if (a*(a-1)/2==b){
                rs++;
            }
        }
        return rs;
    }
}
class UnionFind{
    public int[] parent;
    public int[] pointCount;
    public int[] edgeCount;
    public UnionFind(int n) {
        parent = new int[n];
        pointCount = new int[n];
        edgeCount = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            pointCount[i] = 1;
        }
    }

    public int find(int x){
        if (x!=parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX==rootY){
            edgeCount[rootX]+=1;
            return;
        }
        if (pointCount[rootX]< pointCount[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }
        parent[rootX] = rootY;
        pointCount[rootY] += pointCount[rootX];
        edgeCount[rootY] += (edgeCount[rootX]+1);
    }

    public boolean connected(int x, int y){
        return find(x)==find(y);
    }
}
