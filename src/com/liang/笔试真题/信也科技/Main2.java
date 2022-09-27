package com.liang.笔试真题.信也科技;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    boolean[][] visit;
    int[][] seats;
    int rs;
    int n;
    int m;
    public int getNumberOfGroup (int[][] seats) {
        // write code here
        n = seats.length;
        m = seats[0].length;
        visit = new boolean[n][m];
        rs = 0;
        this.seats = seats;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, false);
            }
        }
        return rs;
    }
    public void dfs(int i, int j, boolean has){
        if (i<0 || j<0 ||i>=n||j>=m ||visit[i][j]){
            return;
        }
        visit[i][j] = true;
        if (seats[i][j]==0){
            return;
        }
        if (!has) rs++;
        has = true;
        dfs(i-1, j, has);
        dfs(i+1, j, has);
        dfs(i, j-1, has);
        dfs(i, j+1, has);
    }
}
