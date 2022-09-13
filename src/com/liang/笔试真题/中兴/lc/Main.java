package com.liang.笔试真题.中兴.lc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] record = new int[n][2];
        for (int i = 0; i < n; i++) {
            record[i][0] = sc.nextInt();
            record[i][1] = sc.nextInt();
        }
        Arrays.sort(record, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }
                return o1[0]-o2[0];
            }
        });
        int l = record[0][0];
        int r = record[0][1];
        int rs = 0;
        for (int i = 1; i < n; i++) {
            int a = record[i][0];
            int b = record[i][1];
            if (b<=r){
                rs++;
            } else {
                l = a;
                r = b;
            }
        }
        System.out.println(n-rs);
    }
}
