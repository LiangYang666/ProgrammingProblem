package com.liang.笔试真题.携程.yl;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        if (k==1){
            System.out.println(a[a.length-1]-a[0]);
            return;
        } else if (k==n){
            System.out.println(0);
            return;
        }
        double min = 0;
        double max = 0;
        long sum = 0;
        for (int i = 0; i < k-(k%2); i++) {
            if (i%2==0){
                sum+=a[i/2];
            } else {
                sum+=a[a.length-1-i/2];
            }
        }
        if(k%2==0){
            min = sum*1.0/k;
            max = min;
            min = Math.min(min, a[k/2]);
            max = Math.max(max, a[a.length-1-k/2]);
            System.out.println(max-min);
        } else {
            double err = 0;
            double sum0 = sum+a[k/2];
            min = sum0*1.0/k;
            max = min;
            min = Math.min(min, a[k/2]+1);
            max = Math.max(max, a[a.length-1-k/2]);
            err = max-min;


            sum0 = sum+a[a.length-1-k/2];
            min = sum0*1.0/k;
            max = min;
            min = Math.min(min, a[k/2]);
            max = Math.max(max, a[a.length-1-1-k/2]);
            if (err<(max-min)){
                System.out.println(err);
            } else {
                System.out.println(max-min);
            }
        }
    }
}
