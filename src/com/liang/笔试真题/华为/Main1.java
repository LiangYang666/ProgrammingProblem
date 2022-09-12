package com.liang.笔试真题.华为;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] ziyuan = new int[m];
        int low = 0;
        int fast=0;
        int aN = 0;
        int bN = 0;
        String last;

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("A")){
                while (aN<m && ziyuan[aN]==4){
                    aN++;
                }
                if (aN==m) {
                    System.out.println(0);
                    System.out.println(0);
                } else {
                    ziyuan[aN]++;
                    if (i==n-1){
                        System.out.println(aN+1);
                        System.out.println(ziyuan[aN]);
                    }
                }
            } else {
                while (bN<m && ziyuan[bN]>0){
                    bN++;
                }
                if (bN==m) {
                    System.out.println(0);
                    System.out.println(0);
                } else {
                    ziyuan[bN]+=4;
                    if (i==n-1){
                        System.out.println(bN+1);
                        System.out.println(1);
                    }
                }
            }
        }


    }
}
