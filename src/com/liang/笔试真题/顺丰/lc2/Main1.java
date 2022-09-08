package com.liang.笔试真题.顺丰.lc2;

import java.util.Scanner;

public class Main1 {
    static int n ;
    static String s;
    static int rs;
    static int mod = (int) (1e9+7);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.next();
        rs = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (s.charAt(i-1)=='1' && (c=='1' || c=='0')){
                dp[i+1] = (dp[i]+dp[i-1])%mod;
            }else {
                dp[i+1] = dp[i];
            }
        }
        System.out.println(dp[n]);
    }

//    public void dfs(int index){
//        if (index==n){
//            rs = (rs+100000000)
//        }
//    }

}
