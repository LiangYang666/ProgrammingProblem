package com.liang.笔试真题.美团.秋招.hz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k =  sc.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        int[][] dp = new int[k][n+2];
        for (int i = 0; i < n; i++) {
            int ci = c[i]-1;
            for (int j = 0; j < k; j++) {
                dp[j][i+1] = dp[j][i];
                if (ci==j){
                    dp[j][i+1] = dp[j][i]+1;
                }
            }
            dp[c[i]-1][i+1] = dp[c[i]-1][i]+1;
        }
        for (int i = 0; i < k; i++) {
            dp[i][n+1] = (int) Math.ceil(dp[i][n]/2.0);
        }
        ArrayList<Integer> train = new ArrayList<>();
        ArrayList<Integer> test = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int ci = c[i]-1;
            if (dp[ci][i+1]<=dp[ci][n+1]){
                train.add(i+1);
            } else {
                test.add(i+1);
            }
        }
        for (int i = 0; i < train.size(); i++) {
            if (i!=0) System.out.print(" ");
            System.out.print(train.get(i));
        }
        System.out.println();
        for (int i = 0; i < test.size(); i++) {
            if (i!=0) System.out.print(" ");
            System.out.print(test.get(i));
        }
        System.out.println();
    }
}
