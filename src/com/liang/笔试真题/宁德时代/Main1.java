package com.liang.笔试真题.宁德时代;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        System.out.println(reverse(100));
    }
    static
    public int reverse (int code) {
        if (code==Integer.MIN_VALUE)   return 0;
        // write code here
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        int temp = code;
        if (temp<0) temp=-temp;
        String s = ""+temp;
        int rs = 0;
        for (int i = 0; i < s.length(); i++) {
            int tt = (s.charAt(i)-'0');
            if (i==9 && tt>2)   return 0;
            int num = tt * (int)Math.pow(10, i);
            if (Integer.MAX_VALUE-num<rs)   return 0;
            rs += num;
        }
        if (code<0) return -rs;
        return rs;
    }
}
