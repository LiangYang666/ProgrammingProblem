package com.liang.面试常考算法题.codeTop;

public class T25字符串相加 {
    public String addStrings(String num1, String num2) {
        int n = Math.max(num1.length(), num2.length());
        char[] chars = new char[n + 1];
        char c = 0;
        for (int i = 0; i < n + 1; i++) {
            char total = c;
            total+= num1.length()-i-1>=0 ? num1.charAt(num1.length()-i-1)-'0':0;
            total+= num2.length()-i-1>=0 ? num2.charAt(num2.length()-i-1)-'0':0;
            chars[n-i] = (char) ((char) (total%10)+'0');
            c = 0;
            if (total>=10){
                c = 1;
            }
        }
        if (chars[0]=='0'){
            return String.copyValueOf(chars, 1, n);
        }
        return String.copyValueOf(chars, 0, n+1);
    }
}
