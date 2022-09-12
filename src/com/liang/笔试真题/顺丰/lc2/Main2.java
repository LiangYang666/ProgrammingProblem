package com.liang.笔试真题.顺丰.lc2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int[] pre = new int[n+1];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)=='0'){
                pre[i+1] = pre[i]-1;
            } else {
                pre[i+1] = pre[i]+1;
            }
        }
        int max = 0;
        int minLeft = pre[0];
        for (int i = 2; i < n+1; i++) {
            if (pre[i-1]<minLeft){
                minLeft  = pre[i-1];
            }
            max = Math.max(max, pre[i]-minLeft);
        }
        System.out.println(max);
    }
}

