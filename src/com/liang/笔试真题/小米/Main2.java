package com.liang.笔试真题.小米;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+1;
                int temp = dp[i-1][j-1];
                if (a.charAt(i-1)==b.charAt(j-1)){
                    temp+=1;
                }
                dp[i][j] = Math.min(dp[i][j], temp);
            }
        }
        System.out.println(dp[m][n]);
    }
}
