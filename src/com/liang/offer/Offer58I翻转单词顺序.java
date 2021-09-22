package com.liang.offer;

import java.util.Arrays;

public class Offer58I翻转单词顺序 {
    public static void main(String[] args) {
        System.out.println(reverseWords("  a   bc def "));
    }
    static
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" +");
        System.out.println(Arrays.toString(strings));
        String rs = "";
        for (int i=strings.length-1; i >= 0; i--) {
            rs = rs + strings[i];
            rs = (i==0? rs:rs+" ");
        }
        return rs;
    }
}
