package com.liang.笔试真题.京东.秋招;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int max = a[a.length-1];
        for (int i = n-1; i >= 0; i--) {
            if (a[i]!=max) {
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(0);
    }
}
