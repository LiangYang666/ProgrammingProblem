package com.liang.笔试真题.小红书;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    static ArrayList<Integer>[] son;
    static int[][] dp;
    static int[] weight;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        weight = new int[n+1];
        for (int i = 0; i < n; i++) {
            weight[i+1] = sc.nextInt();
        }
        son = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            son[i] = new ArrayList<>();
        }
        boolean[] haveParent = new boolean[n+1];
        for (int i = 0; i < n - 1; i++) {
            int l = sc.nextInt();
            int k = sc.nextInt();
            son[k].add(l);
            haveParent[l] = true;
        }
        dp = new int[n+1][2];
        for (int i = 1; i < n+1; i++) {
            if (!haveParent[i]){
                dfs(i);
                System.out.println(Math.max(dp[i][0], dp[i][1]));
                break;
            }
        }
    }
    static void dfs(int node){
        dp[node][0] = 0;
        dp[node][1] = weight[node];
        for (int i = 0; i < son[node].size(); i++) {
            int s = son[node].get(i);
            dfs(s);
            dp[node][0] += Math.max(dp[s][0], dp[s][1]);
            dp[node][1] += dp[s][0];
        }
    }
}
