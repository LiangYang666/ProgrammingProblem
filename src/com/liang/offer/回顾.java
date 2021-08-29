package com.liang.offer;

import java.util.Arrays;

public class 回顾 {
    public static void main(String[] args) {
        System.out.println(strStr("adcababcdab", "ababc"));

    }
    static public int strStr(String s, String p){
        int m=s.length(), n=p.length();
        int[] pi = new int[n];
        int j=0;
        for (int i = 1; i < n; i++) {
            while (j!=0 && p.charAt(i)!=p.charAt(j)){
                j = pi[j-1];
            }
            if(p.charAt(i)==p.charAt(j)){
                j++;
            }
            pi[i] = j;
        }

        for (int i = 0; i < m; i++) {
            while(j!=0 && s.charAt(i)!=p.charAt(j)){
                j = pi[j-1];
            }
            if(s.charAt(i)==p.charAt(j)){
                if(++j==n){
                    return i-j+1;
                }
            }
        }
        return -1;
    }

}
