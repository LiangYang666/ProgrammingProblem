package com.liang.offer;

import java.util.Arrays;

public class MOffer49丑数 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(45));
        System.out.println(nthUglyNumber(40));
    }
    static
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;  // *2 *3 *5
        int[] a = {0, 0, 0};
        int[] b = {2, 3, 5};
        int[] c = {0, 0, 0};
        for (int i = 1; i < n; i++) {
            int minValue = Integer.MAX_VALUE;
            for (int i1 = 0; i1 < a.length; i1++) {
                c[i1] = dp[a[i1]]*b[i1];
                minValue = Math.min(c[i1], minValue);
            }
            for (int i1 = 0; i1 < a.length; i1++) {
                if (minValue==c[i1]){
                    a[i1]++;
                }
            }
            dp[i] = minValue;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }

}
