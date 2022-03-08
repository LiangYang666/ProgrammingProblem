package com.liang.笔试.阿里云实习面试;

import java.util.Scanner;

public class 晶体的数目 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rs=0;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int sum=0;
            for (int j = 0; j <= b; j++) {
                sum+=(a-2)*j+1;
            }
            rs+=sum;
        }
        System.out.println(rs);

    }
}
