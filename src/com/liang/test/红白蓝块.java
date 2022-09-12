package com.liang.test;

import java.util.Scanner;

public class 红白蓝块 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int[] rs ={2,2,2,2,2,2,2,2,2,2};
        int l=0, r=9;
        for (int i = 0; i < 10; i++) {
            if(s[i].equals("1")){
                rs[l++]=1;
            }
            else if(s[i].equals("3")){
                rs[r--]=3;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(rs[i]+" ");
        }
    }
}
