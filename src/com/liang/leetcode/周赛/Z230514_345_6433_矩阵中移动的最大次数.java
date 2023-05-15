package com.liang.leetcode.周赛;

public class Z230514_345_6433_矩阵中移动的最大次数 {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        if (m==0)   return 0;
        int n = grid[0].length; // 列
        int[][] rs = new int[m][n];
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    int newJ = j+k-1;
                    if (newJ>=0 && newJ<m && grid[j][i]<grid[newJ][i+1]){
                        rs[j][i] = Math.max(rs[newJ][i+1]+1, rs[j][i]);
                    }
                }
            }
        }
        int r = 0;
        for (int i = 0; i < m; i++) {
            r = Math.max(r, rs[i][0]);
        }
        return r;
    }
}
