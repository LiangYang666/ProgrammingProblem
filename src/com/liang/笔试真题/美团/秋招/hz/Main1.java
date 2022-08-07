package com.liang.笔试真题.美团.秋招.hz;

import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = Math.min(a, b);
            ans = Math.min(ans, (a+b)/3);
            System.out.println(ans);
        }
    }

}
