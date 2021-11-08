package com.liang.offer;

public class MOffer63股票的最大利润 {
    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
    static
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 0;
        int max_now = 0;
        int max_l = 0;
        while(r<prices.length){
            if(prices[r]<prices[l]){
                l = r;
                max_l = Math.max(max_l, max_now);
                max_now = 0;
            } else {
                int temp = prices[r] - prices[l];
                max_now = Math.max(temp, max_now);
            }
            r++;
        }
        return Math.max(max_l, max_now);
    }
}
