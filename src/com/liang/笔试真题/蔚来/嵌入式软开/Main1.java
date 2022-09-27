package com.liang.笔试真题.蔚来.嵌入式软开;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            max = Math.max(max, a[i]);
            min = Math.min(min,a[i]);
        }
        int[] cac = new int[max - min + 1];
        for (int i = 0; i < n; i++) {
            cac[a[i]-min]++;
        }
        int temp = 0;
        int rs = 0;
        for (int i = 1; i < cac.length; i++) {
            temp++;
            if (cac[i] > 0) {
                rs = Math.max(rs, temp);
                temp=0;
            }
        }
        System.out.println(rs);
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            max = Math.max(a[i]-a[i-1], max);
        }
        System.out.println(max);
    }
}
