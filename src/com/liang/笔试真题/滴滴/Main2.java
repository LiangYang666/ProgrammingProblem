package com.liang.笔试真题.滴滴;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 一共刷n次墙
        int p = sc.nextInt();   // 1号漆所需次数
        int q = sc.nextInt();   // 2号漆所需次数
        int[][] shua = new int[n][3];   // 两维 n*3，第二维是l,r,t依次为栅栏起始、栅栏结尾、所刷的漆号(1、2)
        int max = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                shua[j][i] = sc.nextInt();
                if (i==1){
                    max = Math.max(max,shua[j][i]);
                }
            }
        }
        int[][] has = new int[max + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = shua[i][0]; j <=shua[i][1]; j++) {
                has[j][shua[i][2]-1]++;
            }
        }
        long rs = 0;
        for (int i = 0; i <= max; i++) {
            if (has[i][0]>=p && has[i][1]>=q){
                rs++;
            }
        }
        System.out.println(rs);
    }
}
