package com.liang.笔试真题.米哈游;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {
    static BigInteger func(BigInteger n){
        BigInteger l = BigInteger.valueOf(1);
        BigInteger r = n;
        while (l.compareTo(r)<=0){
            BigInteger m = l.add(r).divide(BigInteger.valueOf(2));
            int vv = m.multiply(m.add(BigInteger.valueOf(1))).compareTo(n.multiply(BigInteger.valueOf(2)));
            if (vv==0){
                return m;
            } else if(vv==1){
                r = m;
            } else {
                l = m.add(BigInteger.valueOf(1));
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            BigInteger bigInteger = sc.nextBigInteger();
            System.out.println(func(bigInteger));
        }
    }
}
