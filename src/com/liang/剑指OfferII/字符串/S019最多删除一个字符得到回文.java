package com.liang.剑指OfferII.字符串;

public class S019最多删除一个字符得到回文 {
    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(validPalindrome(s));
    }

    static
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l<r) {
            if (s.charAt(l)!=s.charAt(r)){
                return validAll(s, l, r-1)||validAll(s, l+1, r);
            }
            l++;
            r--;
        }
        return true;
    }
    static
    public boolean validAll(String s, int l, int r){
        while (l<r) {
            if (s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
