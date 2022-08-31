package com.liang.笔试真题.小红书;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        Long[] a = new Long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        Arrays.sort(a, Comparator.reverseOrder());
//        System.out.println(Arrays.toString(a));
        long total = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                long temp = a[i]*a[j];
                if (temp>=k){
                    total++;
                } else {
                    break;
                }
            }
        }
        System.out.println(total*2);
    }
}
