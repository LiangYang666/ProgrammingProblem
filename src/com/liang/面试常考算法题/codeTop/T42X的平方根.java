package com.liang.面试常考算法题.codeTop;

public class T42X的平方根 {
    public static void main(String[] args) {

    }
    static
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int ans = 0;
        while (l<=r){
            int m = (l+r)>>1;
            long mm = (long) m *m;
            if (mm==x){
                return m;
            } else if (mm<x){
                ans = m;
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return ans;
    }
}
