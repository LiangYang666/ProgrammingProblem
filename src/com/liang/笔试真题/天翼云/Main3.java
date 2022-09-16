package com.liang.笔试真题.天翼云;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    static int n;
    static int[][] arr;
    static int rs;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int power = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n][2];
        rs = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
        }
        sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i][1] = sc.nextInt();
        }
        dfs(0, power, 0);
        System.out.println(rs);
    }
    static
    public void dfs(int i, int power, int get){
        if (power>=0){
            rs = Math.max(rs, get);
        } else{
            return;
        }
        if (i==n) return;
        dfs(i+1, power, get);
        dfs(i+1, power-arr[i][1], get+arr[i][0]);
    }
}
