package com.liang.笔试真题.京东.秋招;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    static int[] left;
    static int[] right;
    static int[] canOk;
    static int[] canOkL;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int rs = 0;
        left = new int[n + 1];
        right = new int[n + 1];

        canOk = new int[n+1];
        canOkL = new int[n+1];

        int lT = 0;
        int rT = 0;
        for (int i = 0; i < n; i++) {
            left[i+1] = left[i];
            right[i+1] = right[i];
            canOk[i+1] = canOk[i];
            canOkL[i+1] = canOkL[i];
            if (s.charAt(i)=='('){
                lT++;
                left[i+1]++;
            }else {
                if (lT>0){
                    rT++;
                    lT--;
                }
                canOk[i+1] = rT;
                canOkL[i+1] = lT;
                right[i+1]++;
            }
        }
        System.out.println(Arrays.toString(canOk));
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                rs += (canOk[j+1]-canOkL[i]);
            }
        }
        System.out.println(rs*2);
    }
//    static int get(int l, int r, String s){
//        int left = 0;
//        int canOk = 0;
//        for (int i = l; i < r+1; i++) {
//            if (s.charAt(i)=='('){
//                left++;
//            } else {
//                if (left>0){
//                    canOk++;
//                    left--;
//                }
//            }
//        }
//        return canOk;
//    }
}
