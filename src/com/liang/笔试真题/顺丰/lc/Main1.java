package com.liang.笔试真题.顺丰.lc;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = 1000000009;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] =1;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i-3]+dp[i-2])%mod+dp[i-1]+1)%mod;
        }
        System.out.println(dp[n]);
    }
}
