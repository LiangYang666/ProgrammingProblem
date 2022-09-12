package com.liang.笔试真题.小红书;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int id = sc.nextInt();
        int[][] weight = new int[n][2];
        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int j = 0; j < m; j++) {
                t+= sc.nextInt();
            }
            weight[i][0] = t;
            weight[i][1] = i;
        }
        Arrays.sort(weight, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < n; i++) {
            if (weight[i][1]==(id-1)){
                System.out.println(i+1);
                return;
            }
        }
    }
}
