package com.liang.笔试真题.字节.hu;

import com.liang.类别.扫描线.DIndex391完美矩形;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        long[] sum = new long[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum[i+1] = sum[i]+arr[i];
        }
        long maxN = Integer.MIN_VALUE;
        for (int i = 0; i < N - K; i++) {
            long temp = sum[i+K+1]-sum[i];
            int minN = Integer.MAX_VALUE;
            for (int j = i; j < i+ K+1; j++) {
                minN = Math.min(minN, arr[j]);
            }
            maxN =  Math.max(temp-minN, maxN);
        }
        System.out.println(maxN);
    }
}
