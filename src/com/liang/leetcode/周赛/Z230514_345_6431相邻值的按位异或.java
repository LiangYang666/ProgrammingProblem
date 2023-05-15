package com.liang.leetcode.周赛;

public class Z230514_345_6431相邻值的按位异或 {
    public static void main(String[] args) {
        System.out.println(doesValidArrayExist(new int[]{1, 1, 1}));
    }
    static
    public boolean doesValidArrayExist(int[] derived) {
        boolean now = false;
        for (int i = 0; i < derived.length; i++) {
            if (derived[i]==1){
                now = !now;
            }
        }
        return now==false;
    }
}
