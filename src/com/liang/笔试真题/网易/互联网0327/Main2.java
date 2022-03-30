package com.liang.笔试真题.网易.互联网0327;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        int[] dp = new int[n+1];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)==s.charAt(i-1)){
                dp[i+1] = Math.max(dp[i-1]+(s.charAt(i)-'a'+1)*2, dp[i]);
            } else if (Math.abs(s.charAt(i)-s.charAt(i-1))==1){
                dp[i+1] = Math.max((dp[i-1]+s.charAt(i)-'a'+s.charAt(i-1)-'a'+2), dp[i]);
            } else {
                dp[i+1] = dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[n]);
    }
}
