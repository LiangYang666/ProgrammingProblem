package com.liang.笔试真题.网易.互娱;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            char[][] paper = new char[N][N];
            for (int j = 0; j < N; j++) {
                paper[j] = sc.next().toCharArray();
            }
            int t = M/N;
            if (M%N!=0){
                t++;
            }
            t*=N;
            if (t%M%2!=0){
                t+=N;
            }
            int start = (t-M)/2;
            int end = t-start;
            for (int j = 0; j < t; j++) {
                for (int k = 0; k < t; k++) {
                    if (j>=start && j<end && k>=start && k<end){
                        System.out.print(paper[j%N][k%N]);
                    }
                }
                if (j>=start && j<end)
                    System.out.println();
            }
            if (i!=T-1)
                System.out.println();
        }
    }
}
