package com.liang.offer;

import java.util.Arrays;

public class MOffer46把数字翻译成字符串 {
    public static int total = 0;
    public static void main(String[] args) {
        System.out.println(translateNum0(122508));
    }
    static
    public int translateNum0(int num) { //非递归方法

        String number = String.valueOf(num);
        int[] dp = new int[number.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < number.length(); i++) {
            dp[i+1] = dp[i];
            if((String.valueOf(number.charAt(i-1))+number.charAt(i)).compareTo("25")<=0 && number.charAt(i-1)!='0'){
                dp[i+1] += dp[i-1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[number.length()];
    }
    static
    public int translateNum1(int num) {     //递归方法
        String number = String.valueOf(num);
        dp(number, 0, "");
        return total;
    }
    static
    void dp(String number, int i, String now){
        if (number.length()==i){
            System.out.println(now);
            total++;
            return;
        }
        int a = number.charAt(i)- '0';
        if(a==0 || number.length()-1==i){
            dp(number, i+1, now + (char) ('a'+a));
            return;
        }
        int b = number.charAt(i+1)-'0';
        if(a*10+b>25){
            dp(number, i+1, now + (char) ('a'+a));
        } else{
            dp(number, i+1, now + (char)('a'+a));
            dp(number, i+2, now + (char) ('a'+(a*10+b)));
        }
    }
    static
    void dp1(String number, int i){
        if (number.length()==i){
            total++;
            return;
        }
        int a = number.charAt(i)- '0';
        if(a==0 || number.length()-1==i){
            dp1(number, i+1);
            return;
        }
        int b = number.charAt(i+1)-'0';
        if(a*10+b>25){
            dp1(number, i+1);
        } else{
            dp1(number, i+1);
            dp1(number, i+2);
        }
    }
}
