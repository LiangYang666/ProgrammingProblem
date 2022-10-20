package com.liang.笔试真题.百度;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            Arrays.sort(a);
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            for (int j = 1; j < n; j++) {
                if (a[j]!=a[j-1]){
                    list.add(j);
                }
            }
            int lI = 0;
            int rI = 0;
            boolean flag = false;
            for (; rI < list.size(); rI++) {
                if (list.get(rI)-list.get(lI)==k){
                    flag = true;
                    break;
                } else if (list.get(rI)-list.get(lI)>k){
                    lI++;
                }
            }
            if (flag){
                System.out.println(a[list.get(lI)]+" "+a[(list.get(rI)-1)]);
            } else {
                System.out.println(-1);
            }
        }
    }
}
