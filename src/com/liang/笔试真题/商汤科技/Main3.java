package com.liang.笔试真题.商汤科技;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    public int pick (int[] nums) {
        // write code here
        int n = nums.length;
        int[] dp = new int[n+1];
        for (int i = 0; i < n - 1; i++) {
            dp[i+2] = Math.max(dp[i+1], dp[i]+nums[i]);
        }
        int rs1= dp[n];
        for (int i = 0; i < n - 1; i++) {
            dp[i+2] = Math.max(dp[i+1], dp[i]+nums[i+1]);
        }
        return Math.max(dp[n], rs1);
    }
}
