package com.liang.笔试真题.京东;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String x = sc.next();
        String s = sc.next();
        BigInteger num = new BigInteger(x);
        BigInteger two = BigInteger.valueOf(2);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)=='U'){
                num = num.divide(two);
            } else if(s.charAt(i)=='L'){
                num = num.multiply(two);
            } else{
                num = num.multiply(two).add(BigInteger.ONE);
            }
        }
        System.out.println(num);
    }
}
