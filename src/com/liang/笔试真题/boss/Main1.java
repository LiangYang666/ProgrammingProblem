package com.liang.笔试真题.boss;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        for (int i = (int) Math.min(a, b); i > 0 ; i--) {
            if (a%i==0 && b%i==0){
                System.out.println(a*b/i);
                break;

            }
        }
    }
}
