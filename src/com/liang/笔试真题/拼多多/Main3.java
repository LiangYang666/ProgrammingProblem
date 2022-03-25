package com.liang.笔试真题.拼多多;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String B = sc.next();
        int n = B.length();
        char[] A = new char[n];
        for (int i = 0; i < n; i++) {
            if (B.charAt(i)=='0'){
                if(i>=k) A[i-k] = '0';
                if((i+k)<n)A[i+k] = '0';
            } else {
                if (i<k){
                    A[i+k] = '1';
                } else if((i+k)>=n){
                    A[i-k] = '1';
                } else {
                    if (A[i-k]==0){
                        A[i-k] = '0';
                        A[i+k] = '1';
                    } else if(A[i-k]=='1') {
                        A[i+k] = '0';
//                        kebian.add( +k);
                    } else if(A[i-k]=='0') {
                        A[i+k] = '1';
                    }
                }
            }
        }
        System.out.println(new String(A));
    }
}
