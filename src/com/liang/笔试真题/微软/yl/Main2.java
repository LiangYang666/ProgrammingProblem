package com.liang.笔试真题.微软.yl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        System.out.println(solution("54321"));
    }
    static
    public String solution(String S) {
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        ArrayList<Character> even = new ArrayList<>();
        ArrayList<Character> odd = new ArrayList<>();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i-1]==chars[i]){
                even.add(chars[i]);
                i++;
                if (i==chars.length-1){
                    odd.add(chars[i]);
                }
            } else {
                odd.add(chars[i-1]);
                odd.add(chars[i]);
            }
        }
        int evenTotal = even.size();
        if (evenTotal>0){
            if (even.get(even.size()-1).equals('0')){
                evenTotal = 0;
            }
        }

        char[] rs;
        if (odd.size()!=0){
            rs = new char[evenTotal*2+1];
        } else {
            rs = new char[evenTotal*2];
        }
        if (rs.length==0){
            return "0";
        }
        for (int i = 0; i < evenTotal; i++) {
            char c = even.get(evenTotal-i-1);
            rs[i] = c;
            rs[rs.length-1-i] = c;
        }
        if (odd.size()!=0){
            rs[evenTotal]=odd.get(odd.size()-1);
        }
        return String.copyValueOf(rs);
    }
}
