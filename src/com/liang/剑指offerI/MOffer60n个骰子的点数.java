package com.liang.剑指offerI;

import java.util.Arrays;

public class MOffer60n个骰子的点数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dicesProbability(2)));

    }
    static
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        for (int i = 0; i < 6; i++) {
            dp[i] = 1.0/6;
        }
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j+(k+1)-1] += dp[j]/6;
                }
            }
            dp = tmp;
        }
        return dp;
    }



    /*  超时
    int times = 0;
    public double[] dicesProbability(int n) {
        double[] rs = new double[n * 6 - n + 1];
        int j = 0;

        for (int i = n; i <= n*6; i++) {
            times = 0;
            if(i==8) System.out.println("-----------------");
            dp(i, n);
            rs[j++] = Math.pow(1.0/6.0, n)*times;
        }
        return rs;
    }
    public void dp(int num, int n){     //全排列
        if (n==1){
            if(num<=6 && num>=1){
                times += 1;
                System.out.println(num);
            }
        }
        else {
            for (int i = 1; i <= Math.min(num - (n - 1), 6); i++) {
                dp(num - i, n - 1);
            }
        }
    }
     */
}
