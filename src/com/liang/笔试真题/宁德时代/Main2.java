package com.liang.笔试真题.宁德时代;

import java.util.Scanner;

public class Main2 {
    static int[] voltages;
    static int rs =0;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        voltages = new int[n];
        for (int i = 0; i < n; i++) {
            voltages[i] = sc.nextInt();
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        dfs(a, b, 0);
        System.out.println(rs);
    }
    static void dfs(int a, int b, int index){
        if (a==0 && b==0)   rs++;
        if (index==n || a<0 || b<0)   return;
        dfs(a-voltages[index], b, index+1);
        dfs(a, b-voltages[index], index+1);
    }
}
