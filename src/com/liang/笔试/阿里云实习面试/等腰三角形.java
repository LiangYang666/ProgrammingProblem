package com.liang.笔试.阿里云实习面试;

import java.util.Scanner;

public class 等腰三角形 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        String s = scanner.nextLine();
        long n = Long.parseLong(s);
        System.out.println(((n-1)*(n-2))*n/6-(n/2-1)*(n/2)/2*n);
    }
}
