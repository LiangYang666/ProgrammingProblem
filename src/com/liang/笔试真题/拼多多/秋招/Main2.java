package com.liang.笔试真题.拼多多.秋招;

import java.util.Scanner;

public class Main2 {
    static int mod = 100000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int mi = sc.nextInt();
            int[] mm = new int[mi];
            int max = 0;
            for (int j = 0; j < mi; j++) {
                mm[j] = sc.nextInt();
                max = Math.max(mm[j], max);
            }
            if (max>p){
                System.out.println(0);
                continue;
            }
            System.out.println(func(mm, p, k));
        }
    }
    static int func(int[] mm, int p,int k){
        int mi = mm.length;
        int[] dp = new int[mi+1];
        dp[0] = 1;
        for (int i = 1; i <= mi; i++) {
            int kNum = 0;
            int pTotal = 0;
            for (int j = i-1; j >=0; j--) {
                kNum++;
                if (kNum>k){
                    break;
                }
                pTotal+=mm[j+1-1];
                if (pTotal>p){
                    break;
                }
                dp[i] += dp[j];
                dp[i]%=mod;
            }
        }
        return dp[mi];
    }
}
