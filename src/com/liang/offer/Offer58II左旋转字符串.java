package com.liang.offer;

public class Offer58II左旋转字符串 {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
    static
    public String reverseLeftWords(String s, int n) {
        int l = s.length();
        if (l<=1)   return s;
        n %= l;
        if (n==0)   return s;
        char[] ss = s.toCharArray();
        String rs1 = String.copyValueOf(ss, n, l-n);
        return rs1+String.copyValueOf(ss, 0, n);
    }
}
