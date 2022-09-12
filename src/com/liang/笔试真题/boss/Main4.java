package com.liang.笔试真题.boss;

import java.util.Scanner;

public class Main4 {
    // 买卖股票III
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] dp = new int[4];
        dp[0] = -a[0];
        dp[1] = 0;
        dp[2] = -a[0];
        dp[3] = 0;
        for (int i = 0; i < n; i++) {
            dp[0] = Math.max(dp[0], -a[i]);
            dp[1] = Math.max(dp[1], a[i]+dp[0]);
            dp[2] = Math.max(dp[2], dp[1]-a[i]);
            dp[3] = Math.max(dp[3], a[i]+dp[2]);
        }
        System.out.println(dp[3]);
    }
}
