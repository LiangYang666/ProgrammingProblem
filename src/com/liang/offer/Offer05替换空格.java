package com.liang.offer;

import java.util.Arrays;

public class Offer05替换空格 {

    public static void main(String[] args) {
        String s = "wwww daf";
        System.out.println(replaceSpace(s));
    }

    static
    public String replaceSpace(String s) {
        char[] chars = new char[s.length()*3];
        int j =0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '){
                chars[j++] = '%';
                chars[j++] = '2';
                chars[j++] = '0';
            }
            else {
                chars[j++] = s.charAt(i);
            }
        }
        return String.valueOf(chars,0, j);
    }
}
