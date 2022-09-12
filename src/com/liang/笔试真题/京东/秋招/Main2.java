package com.liang.笔试真题.京东.秋招;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int max = a[a.length-1];
        dp = new int[max + 1];
        dp[1] = 0;
        for (int i = 2; i < max + 1; i++) {
            dp[i] = Math.min(dp[i-1]+1, get(i));
        }
        int rs = 0;
        for (int i = 0; i < n; i++) {
            rs += dp[a[i]];
        }
        System.out.println(rs);
    }
    static int get(int n){
        int min = Integer.MAX_VALUE;
        for (int i = 2; i < n/2+1; i++) {
            if (n%i==0){
                min = Math.min(min, dp[i]+dp[n/i]+1);
            }
        }
        return min;
    }
}
