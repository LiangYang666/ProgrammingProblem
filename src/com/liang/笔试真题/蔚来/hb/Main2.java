package com.liang.笔试真题.蔚来.hb;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.笔试真题.蔚来.hb
 * @ClassName: Main2
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/8/30 15:16
 * @Version: 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i]+a[i];
        }
        int q = sc.nextInt();
        long[] x = new long[q];
        for (int i = 0; i < q; i++) {
            x[i] = sc.nextInt();
        }
        long now = 0;
        for (int i = 0; i < q; i++) {
            now += x[i];
            int j = getFirstBigger(a, -now);

            long pre = -sum[j]-now*j;
            long back = (sum[n]-sum[j])+now*(n-j);
            System.out.println(pre+back);
        }
    }
    static int getFirstBigger(long[] a, long target){
        int l = 0;
        int r = a.length-1;
        if (a[r]<target)    return r+1;
        while (l<=r){
            int m = (l+r)/2;
            if (a[m]<=target){
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return l;
    }
}
