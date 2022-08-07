package com.liang.笔试真题.科大讯飞;

import java.util.Scanner;

public class Main2 {
    // 布隆算法算法实现
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(";");
        String[] arr1 = split[0].split(",");
        String[] arr2 = split[1].split(",");
        long[] bitMap = new long[1000];
        long rs = 0;
        for (int i = 0; i < arr1.length; i++) {
            int num = Integer.parseInt(arr1[i]);
            int index = num/64;
            bitMap[index] |= ((long) 1)<<(64-num%64);
        }
        for (int i = 0; i < arr2.length; i++) {
            int num = Integer.parseInt(arr2[i]);
            int index = num/64;
            long temp = bitMap[index] & ((long) 1)<<(64-num%64);
            if (temp!=0)    rs++;
        }
        System.out.println(rs);
    }
}
