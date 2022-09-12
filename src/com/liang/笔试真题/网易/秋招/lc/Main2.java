package com.liang.笔试真题.网易.秋招.lc;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        if (t>=k){
            System.out.println(-1);
            return;
        }
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < t+1; i++) {
            rs.append(1);
        }
        int total1 = k-t-1;
        int total0 = n-k;
        int remain = n-t-1;
        if (total1>total0){
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < total1; i++) {
            rs.append(0);
            rs.append(1);
            remain-=2;
        }
        for (int i = 0; i < remain; i++) {
            rs.append(0);
        }
        System.out.println(rs.toString());
    }
}
