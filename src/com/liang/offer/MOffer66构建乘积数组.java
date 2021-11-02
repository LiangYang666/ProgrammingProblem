package com.liang.offer;

import java.util.Arrays;

public class MOffer66构建乘积数组 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArr(new int[]{1, 2, 3, 4, 5})));
    }
    static
    public int[] constructArr(int[] a) {
        int n = a.length;
        if(n==0)    return a;
        int[] b = new int[n];
        int[] c = new int[n];
        c[n-1] = 1;
        b[0] = 1;
        for (int i = 1; i < n; i++) {
            b[i] = a[i-1]*b[i-1];
        }
        for (int i = n-2; i >= 0; i--) {
            c[i] = c[i+1]*a[i+1];
        }
        for (int i = 0; i < n; i++) {
            b[i] *= c[i];
        }
        return b;
    }
}
