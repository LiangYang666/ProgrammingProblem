package com.liang.剑指offerI;

public class Offer65不用加减乘除做加法 {
    public static void main(String[] args) {
        int a = 100;
        int b = -20;
        System.out.println(add(100, -90));
    }
    static
    public int add(int a, int b) {
        while(b!=0){
            int c = (a&b)<<1;
            a^=b;
            b = c;
        }
        return a;
    }
}
