package com.liang.笔试真题.微众银行;

import java.math.BigInteger;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mod = 998244353;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        long rs = 0;
        boolean flag  = false;
        while (true){
            for (int j = n-1; j >= 0; j--) {
                a[j]++;
                if (a[j]<m){
                    break;
                } else if(j==0) {
                    flag=true;
                    break;
                }
                a[j] = 0;
            }
            if (check(a)) rs = (rs+1)%mod;
            if (flag)  {
                break;
            }
        }
        System.out.println(rs);
    }
    static
    public boolean check(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
            if (max>3)  return false;
        }
        return max==3;
    }
}
