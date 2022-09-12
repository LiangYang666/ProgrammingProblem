package com.liang.笔试真题.深信服;

import com.liang.剑指offerI.Offer21奇偶分组;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Main1 main1 = new Main1();


    }
    public int ncov_defect (int[][] grid) {
        // write code here
        int n = grid.length;
        if (n==0)   return 0;
        int m = grid[0].length;
        int rs = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1){
                    if (i>0 && grid[i-1][j]==0){
                        rs++;
                    }
                    if (i < n - 1 && grid[i + 1][j] == 0) {
                        rs++;
                    }
                    if (j>0 && grid[i][j-1]==0){
                        rs++;
                    }
                    if (j < m - 1 && grid[i][j + 1] == 0) {
                        rs++;
                    }
                }
            }
        }
        return rs;
    }
}
