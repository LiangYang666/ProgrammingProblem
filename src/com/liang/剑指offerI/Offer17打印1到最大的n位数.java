package com.liang.剑指offerI;

public class Offer17打印1到最大的n位数 {
    public int[] printNumbers(int n) {
        int[] rs = new int[(int) Math.pow(10, n)-1];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = i+1;
        }
        return rs;
    }
}
