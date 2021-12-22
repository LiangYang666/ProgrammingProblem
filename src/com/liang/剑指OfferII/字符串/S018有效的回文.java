package com.liang.剑指OfferII.字符串;

public class S018有效的回文 {
    public boolean isPalindrome(String s) {
        char[] chars = new char[s.length()];
        int j =0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)){
                chars[j++] = Character.toLowerCase(c);
            }
        }
        int l = 0;
        int r = j-1;
        while(l<r){
            if (chars[l++]!=chars[r--]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2("123"));
    }

    static
    public boolean isPalindrome2(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)){
                buffer.append(Character.toLowerCase(c));
            }
        }
        return buffer.toString().equals(buffer.reverse().toString());
    }
}
