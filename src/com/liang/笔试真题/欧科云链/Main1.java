package com.liang.笔试真题.欧科云链;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        int[] dp = new int[k * 2];
        for (int i = 0; i < 2 * k; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * k; j++) {
                if (j==0){
                    dp[j] = Math.max(dp[j], -prices[i]);
                }else if (j%2==0){
                    dp[j] = Math.max(dp[j], dp[j-1]-prices[i]);
                }else {
                    dp[j] = Math.max(dp[j], dp[j-1]+prices[i]);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[2*k-1]);
    }
}
