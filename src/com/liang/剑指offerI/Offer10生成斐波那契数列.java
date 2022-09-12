package com.liang.剑指offerI;

public class Offer10生成斐波那契数列 {
    public static void main(String[] args) {

    }
    static
    public int fib(int n) {
        int last_l = 0;
        int last = 1;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = last;
            last = (last_l+last) %1000000007;;
            last_l = temp;
        }

        return last_l;

    }
}
