package com.liang.leetcode.周赛;

public class Dec18_324_2507使用质因数之和替换后可以取到的最小值 {

    public int smallestValue(int n) {
        int sum = 0;
        int m = n;
        for (int i = 2;i<=m ; i++) {
            while (m%i==0){
                m /= i;
                sum+=i;
            }
        }
        return n==sum ? n: smallestValue(sum);
    }
}
