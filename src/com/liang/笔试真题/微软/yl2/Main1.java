package com.liang.笔试真题.微软.yl2;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
//        System.out.println(solution("bdaaadadb"));
        System.out.println(solution("bdaaadadb"));
//        System.out.println(solution("abacb"));
//        System.out.println(solution("zthtzh"));

    }
    static
    public int solution(String S) {
        // write your code in Java 8 (Java SE 8)
        System.out.println(S);
        int n = S.length();
        int maxLength = Integer.MIN_VALUE;
        int[][] sum = new int[26][n + 1];
        for (int i = 1; i < n+1; i++) {
            int c = S.charAt(i-1)-'a';
            for (int j = 0; j < 26; j++) {
                if (c==j){
                    sum[c][i] = sum[c][i-1]+1;
                } else {
                    sum[j][i] = sum[j][i-1];
                }
            }
        }
//        for (int i = 0; i < 26; i++) {
//            System.out.print((char)('a'+i));
//            System.out.println(Arrays.toString(sum[i]));
//        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 2; j < n+1; j++) {
                boolean allEven = true;
                for (int k = 0; k < 26; k++) {
                    if ((sum[k][j]-sum[k][i])%2!=0){
                        allEven = false;
                        break;
                    }
                }
                if (allEven){
                    if ((j-i)>maxLength){
                        maxLength = j-i;
                    }
                }
            }
        }
        System.out.println(maxLength);
        return maxLength;
    }
}
