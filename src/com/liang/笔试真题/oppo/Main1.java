package com.liang.笔试真题.oppo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    public int maxDigit (int[] digits) {
        // write code here
        Arrays.sort(digits);
        if (digits[digits.length-1]==0) return 0;
        int rs = 0;
        for (int i = 0; i < digits.length; i++) {
            rs += digits[i]*Math.pow(10, i);
        }
        return rs;
    }
}
