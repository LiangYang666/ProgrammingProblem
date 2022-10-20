package com.liang.笔试真题.携程.yl;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BigInteger zero = new BigInteger("0");
        BigInteger ten = new BigInteger("10");
        BigInteger n233 = new BigInteger("233");
        for (int i = 0; i < t; i++) {
            String a = sc.next();
            int rst = 0;
            BigInteger n = new BigInteger(a);
            BigInteger[] bigIntegers = n.divideAndRemainder(n233);
            if (!bigIntegers[1].equals(zero)){
                rst = -1;
            } else {
                String temp = bigIntegers[0].toString();
                for (int j = 0; j < temp.length(); j++) {
                    rst+=(temp.charAt(j)-'0');
                }
            }
            System.out.println(rst);
        }
    }
}
