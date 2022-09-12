package com.liang.剑指OfferII.整数;

import java.util.Arrays;
import java.util.Comparator;

public class M005单词长度的最大乘积 {
    public static void main(String[] args) {
        String[] w = {"abcw","baz","foo","bar","fxyz","abcdef"};
        System.out.println(maxProduct(w));
    }
    static
    public int maxProduct(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        System.out.println(Arrays.toString(words));
        int n = words.length;
        int[] wordsInt = new int[n];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int cIndex = words[i].charAt(j)-'a';
                wordsInt[i]|=(1<<cIndex);
            }
        }
        int max_mul = 0;
        for (int i = 0; i < n-1; i++) {
            if(words[i].length()*words[i+1].length()<max_mul)   break;
            for (int j = i+1; j < n; j++) {
                if ((wordsInt[i]&wordsInt[j])==0){
                    int temp = words[i].length()*words[j].length();
                    max_mul = Math.max(temp, max_mul);
                    break;
                }
            }
        }
        return max_mul;
    }

    static
    public int maxProduct2(String[] words){
        int[] wordsInt = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int bitIndex = words[i].charAt(j)-'a';
                wordsInt[i]|=1<<bitIndex;
            }
        }
        int maxMul = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((wordsInt[i]&wordsInt[j])==0){
                    maxMul = Math.max(maxMul, words[i].length()*words[j].length());
                }
            }
        }
        return maxMul;
    }
}
