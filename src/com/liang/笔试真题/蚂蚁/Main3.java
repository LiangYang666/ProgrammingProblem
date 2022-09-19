package com.liang.笔试真题.蚂蚁;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
//        int[] map = new int[128];
        int len = s.length();
        int res = 0;
        int[] odds = new int[len];
        for (int i = 0; i < len; i++) {
            int[] map = new int[128];
            int odd = 0;
            for (int j = i; j < len; j++) {
                map[s.charAt(j)]++;
                if (map[s.charAt(j)]%2==0){
                    odd++;
                } else {
                    odd--;
                }
                if (odd==1){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
