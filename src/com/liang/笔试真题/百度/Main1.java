package com.liang.笔试真题.百度;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.length()!=5){
                System.out.println("No");
                continue;
            }
            int[] cac = new int[128];
            for (int j = 0; j < s.length(); j++) {
                cac[s.charAt(j)]++;
            }
            if (cac['B']==1 && cac['a']==1 && cac['i']==1&&cac['d']==1 && cac['u']==1){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
