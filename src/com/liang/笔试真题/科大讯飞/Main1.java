package com.liang.笔试真题.科大讯飞;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int num = sc.nextInt();
        int rs = 0;
        String[] split = s.split(":");
        for (int i = 0; i < split.length; i++) {
            int a = Integer.parseInt(split[i]);
            if (a/8==num){
                rs ++;
            }
            if (a%8==num){
                rs ++;
            }
        }
        System.out.println(rs);

    }
}
