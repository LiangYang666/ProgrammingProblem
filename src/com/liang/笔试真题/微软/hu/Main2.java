package com.liang.笔试真题.微软.hu;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1}, new int[]{2, 2, 2}));
    }

    static
    public int solution(int[] X, int[] Y){
        int n = X.length;
        final double targetY = 10000000000.0;
        double[] dx = new double[n];
        for (int i = 0; i < n; i++) {
            double frac = targetY/Y[i];
            dx[i] = X[i]*frac;
        }
        Arrays.sort(dx);
        int l = 0 ;
        int r = n-1;
        double jingdu = 0.0000001;
        int rs = 0;
        while (l<r){
            double sum = dx[l]+dx[r];
            if (sum>targetY-jingdu){
                r--;
            } else if (sum<targetY+jingdu) {
                l++;
            } else {
                rs ++;
                rs %= 1000000007;
                int lt=l+1;
                while (lt<r){
                    double tSum = dx[lt]+dx[r];
                    if (tSum<targetY+jingdu && tSum>targetY-jingdu){
                        rs++;
                        rs %= 1000000007;
                        lt++;
                    }else {
                        break;
                    }
                }
                int rt = r-1;
                while (l<rt){
                    double tSum = dx[l]+dx[rt];
                    if (tSum<targetY+jingdu && tSum>targetY-jingdu){
                        rs++;
                        rs %= 1000000007;
                        rt--;
                    }else {
                        break;
                    }
                }
                l++;
                r--;
            }
        }
        return rs;
    }
}
