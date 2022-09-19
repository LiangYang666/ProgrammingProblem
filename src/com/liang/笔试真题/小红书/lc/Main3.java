package com.liang.笔试真题.小红书.lc;

import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/9/19 下午3:53
 **/

/*
6 2
1 2 1 3 2 3

 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        long rs = 0;
        for (int i = 0; i < n; i++) {
            int[] cac = new int[n + 1];
            for (int j = i; j < n; j++) {
                cac[a[j]]++;
                if (cac[a[j]]>=k){
                    rs += n-j;
                    break;
                }
            }
        }
        System.out.println(rs);
    }
}
