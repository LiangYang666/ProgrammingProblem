package com.liang.笔试真题.欧科云链;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n+1];
        for (int i = 0; i < n-1; i++) {
            dp[i+2] = Math.max(dp[i+1], dp[i]+arr[i]);
        }
        int rs = dp[n];
        dp = new int[n+1];
        for (int i = 1; i < n; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1]+arr[i]);
        }
        rs = Math.max(dp[n], rs);
        System.out.println(rs);
    }
}
