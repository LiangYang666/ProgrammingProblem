package com.liang.笔试真题.神策数据;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int i = 1;
        int j = -1;
        int total = n*n;
        while (total>0){
            while (i!=0 && j!=n-1){
                total--;
                i--;
                j++;
                System.out.print(arr[i][j]+" ");
            }
            if (total==0)   return;
            if (j==n-1){
                i++;
                total--;
                System.out.print(arr[i][j]+" ");
            } else {
                j++;
                total--;
                System.out.print(arr[i][j]+" ");
            }
            if (total==0)   return;
            while (i!=n-1 && j!=0){
                total--;
                i++;
                j--;
                System.out.print(arr[i][j]+" ");
            }
            if (i==n-1){
                j++;
                total--;
                System.out.print(arr[i][j]+" ");
            } else {
                i++;
                total--;
                System.out.print(arr[i][j]+" ");
            }
        }
    }
}
