package com.liang.面试常考算法题.codeTop;

public class T20岛屿的数量 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int rs = 0;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!flag[i][j] && grid[i][j]=='1'){
                    dfs(grid, flag, i, j);
                    rs++;
                }
            }
        }
        return rs;
    }
    public void dfs(char[][] grid, boolean[][] flag, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i<0 || j<0 || i>=m || j>=n || flag[i][j] || grid[i][j]=='0'){
            return;
        }
        flag[i][j] = true;
        dfs(grid, flag, i, j+1);
        dfs(grid, flag, i, j-1);
        dfs(grid, flag, i+1, j);
        dfs(grid, flag, i-1, j);
    }
}
