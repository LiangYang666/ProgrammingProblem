package com.liang.面试常考算法题.面试;

public class Main2 {
    // 华为二面
    static int rs;
    public static void main(String[] args) {
        int[][] map = {
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 1, 1},
        };
        System.out.println(getLudi(map));
    }
    public static int getLudi(int[][] map){
        rs = 0;
        int n = map.length;
        int m = map[0].length;
        boolean[][] visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, false, map, visit);
            }
        }
        return rs;
    }
    public static void dfs(int i, int j, boolean has, int[][] map, boolean[][] visit){
        if (i<0 || i>=map.length || j<0 || j>=map[0].length || visit[i][j]){
            return;
        }
        visit[i][j] = true;
        if (map[i][j]==0)   return;
        if (map[i][j]==1 && !has){
            rs++;
            has = true;
        }
        if (has){
            dfs(i+1, j, has, map, visit);
            dfs(i-1, j, has, map, visit);
            dfs(i, j-1, has, map, visit);
            dfs(i, j+1, has, map, visit);
        }
    }
}
