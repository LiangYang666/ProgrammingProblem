package com.liang.normal;

import java.util.Arrays;

public class Index28实现str2str {
    public static void main(String[] args) {
        String haystack="abeababeabf";
        String needle = "abeabf";
        System.out.println(strStr(haystack, needle));
    }
    static
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int m = haystack.length();
        int n = needle.length();
        int[] pi = new int[n];
        int j =0;
        for (int i = 1; i < n; i++) {
            while (j!=0 && needle.charAt(i)!=needle.charAt(j)){
                j = pi[j-1];
            }
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
            }
            pi[i] = j;
        }

        System.out.println(Arrays.toString(pi));
        j=0;
        for (int i = 0; i < m; i++) {
            while (j!=0 && needle.charAt(j)!=haystack.charAt(i)){
                j = pi[j-1];
            }
            if(needle.charAt(j)==haystack.charAt(i)){
                j++;
                if(j==n){
                    return i-n+1;
                }
            }
        }

        return -1;
    }

}
