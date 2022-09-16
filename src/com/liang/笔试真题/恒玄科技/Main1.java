package com.liang.笔试真题.恒玄科技;

public class Main1 {
    public static boolean scramble(String str1, String str2) {
        // 在这⾥写代码
        int[] sum1 = new int[128];
        int[] sum2 = new int[128];
        for(int i=0;i<str1.length();i++){
            sum1[str1.charAt(i)]++;
        }
        for(int i=0;i<str2.length();i++){
            sum2[str2.charAt(i)]++;
        }
        for(int i=0;i<128;i++){
            if(sum1[i]<sum2[i]){
                return false;
            }
        }
        return true;
    }
}
