package com.liang.笔试真题.网易.秋招.lc;

import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tt = a[i]%k;
            map.put(tt, map.getOrDefault(tt, 0)+1);
        }
        int max = 0;
        for (Integer integer : map.keySet()) {
            max = Math.max(max, map.get(integer));
        }
        System.out.println(max);
    }
}
