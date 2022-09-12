package com.liang.笔试真题.美团.秋招.lc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[][] index = new int[n][2];
        index[0][1] = sc.nextInt();
        index[0][0] = 2;
        int last = 2;
        int add = 3;
        for (int i = 1; i < n; i++) {
            a[i] = sc.nextInt();
            index[i][0] = (last+add)%4;
            last = index[i][0];
            index[i][1] = a[i];
            add--;
        }
        System.out.println(Arrays.deepToString(index));
        Arrays.sort(index, Comparator.comparingInt(x -> x[0]));
        for (int i = 0; i < n; i++) {
            System.out.println(index[i][1]);
        }
    }
}
