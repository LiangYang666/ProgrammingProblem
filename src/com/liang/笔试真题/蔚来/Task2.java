package com.liang.笔试真题.蔚来;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n+1];
        int[] c = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i < n+1; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 1; i < n+1; i++) {
            c[i] = sc.nextInt();
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < k + 1; j++) {
                if (dp[i-1][j]!=-1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + a[i]);
                }
                if (j>=c[i]&&dp[i-1][j-c[i]]!=-1){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-c[i]]+b[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < k + 1; i++) {
            res = Math.max(res, dp[n][i]);
        }
        System.out.println((1500+res));
    }
}
