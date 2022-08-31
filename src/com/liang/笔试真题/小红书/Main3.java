package com.liang.笔试真题.小红书;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
6
1 2 2 3 3

ans
2
 */
public class Main3 {
    static int[] f;
    static int[] g;
    static int[][] dp;
    static  int[][] pair;
    static int n;
    static ArrayList<Integer>[] conn;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        pair = new int[n - 1][2];
        conn = new ArrayList[n + 1];
        dp = new int[n - 1][2];
        for (int i = 0; i < n + 1; i++) {
            conn[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            pair[i][0] = a;
            pair[i][1] = i+2;

            conn[a].add(i);
            conn[i+2].add(i);
        }
        System.out.println(Arrays.deepToString(pair));
        dfs(0, new boolean[n-1]);
        System.out.println(Math.max(dp[0][0], dp[0][1]));
    }
    static void dfs(int pairIndex, boolean[] visit){
        dp[pairIndex][0] = 0;
        dp[pairIndex][1] = 1;
        visit[pairIndex] = true;
        int a = pair[pairIndex][0];
        int b = pair[pairIndex][1];
        for (int i = 0; i < conn[b].size(); i++) {
            int newPairIndex = conn[b].get(i);
            if (visit[newPairIndex]) continue;
            dfs(newPairIndex, visit);
            dp[pairIndex][0] = Math.max(dp[newPairIndex][0], Math.max(dp[newPairIndex][1],dp[newPairIndex][0]));
            dp[pairIndex][1] += dp[newPairIndex][0];
        }
        visit[pairIndex] = false;
    }
}
