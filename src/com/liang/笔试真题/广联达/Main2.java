package com.liang.笔试真题.广联达;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] lrx = new int[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                lrx[i][j] = sc.nextInt();
            }
        }
//        Arrays.sort(lrx, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0]==o2[0]){
//                    return o1[1]-o2[1];
//                }
//                return o1[0]-o2[0];
//            }
//        });
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int lastJ = 0;
        for (int i = 0; i < m; i++) {
            int l = lrx[i][0];
            int r = lrx[i][1];
            int x = lrx[i][2];
            for (int j = lastJ+1; j < l; j++) {
                dp[j] = dp[j-1]+1;
            }
            int j = l;
//            if (i+1<m){
//               j = lrx[i+1][0];
//            }
            for (; j <= r; j++) {
                dp[j] = dp[l-1]+Math.min(j-l+1, x);
            }
            lastJ = r;
        }
        System.out.println(dp[n]);
    }
}
