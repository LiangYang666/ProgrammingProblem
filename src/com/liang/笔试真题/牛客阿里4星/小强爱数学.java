package com.liang.笔试真题.牛客阿里4星;

import java.util.Scanner;

public class 小强爱数学 {
    public static void main(String[] args) {
        System.out.println((-10+4*10)%4);
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] rs = new int[T];
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
//            System.out.println(a+" "+b+" "+n);
            rs[i] = handle(a,b,n);
//            System.out.println(rs[i]);
        }
        for (int i = 0; i < T; i++) {
            System.out.println(rs[i]);
        }
    }
    public static int handle(long a, long b, int n){
        long mod = 1000000007;
        long[] rs = new long[n + 1];
        rs[0] = 2;
        if(n==0)    return 2;
        rs[1] = a%mod;
        for (int i = 2; i < n+1; i++) {
            rs[i] = (a*rs[i-1]%mod-b*rs[i-2]%mod+mod)%mod;
        }
//        System.out.println(Arrays.toString(rs));
        return (int)rs[n];
    }
}
