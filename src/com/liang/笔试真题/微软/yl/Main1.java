package com.liang.笔试真题.微软.yl;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        int[] Y = new int[]{0,5,3,2,1,5};

//        int[] X = new int[]{2,4,2,6,7,1};
//        int W = 2;

        int[] X = new int[]{4,8,2,2,1,4};
        int W = 3;


//        int[] X = new int[]{0,3,6,5};
//        int W = 1;

        System.out.println(solution(X, Y, W));
    }
    static
    public int solution(int[] X, int[] Y, int W) {
        // write your code in Java 8 (Java SE 8)
        Arrays.sort(X);
        int rs = 0;
        for (int i = 0; i < X.length; ) {
            int start = X[i];
//            System.out.println(i+" "+X[i]);
            rs++;
            while (i<X.length && X[i]<=start+W){
                i++;
            }
        }
        return rs;
    }
}
