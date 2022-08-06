package com.liang.笔试真题.美团.实习;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int negTotal = 0;
        int yes=0;
        int no = 1;
        int rs = 0;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            negTotal+= (temp<0?1:0);
            if (negTotal%2!=0){
                rs += yes;
                yes ++;
            } else {
                rs+=no;
                no++;
            }
        }
        System.out.println(rs);
    }
}
