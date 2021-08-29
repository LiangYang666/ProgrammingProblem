package com.liang.offer;

public class Offer10青蛙跳台阶 {
    public static void main(String[] args) {
        System.out.println(numWays(10));
    }

    static
    public int numWays(int n) {
        if(n<2){
            return 1;
        }
        int a=1, b=1;
        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = (a*1+b*1)%1000000007;
            a = temp;
        }
        return b;


    }
}


