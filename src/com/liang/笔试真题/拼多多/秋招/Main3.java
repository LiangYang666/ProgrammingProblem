package com.liang.笔试真题.拼多多.秋招;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/*
2
4 1 3
x**x
2 4 3
x*

2
4 3 3
x*x*
2 4 3
x*

1
4 1 3
x**x

1
4 3 3
x*x*

 */
public class Main3 {
    static long number;
    static String rs;
    static long n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            m = sc.nextInt();
            n = sc.nextLong();
            number = 0;
            String s = sc.next();
            rs = "";
//            System.out.println(s);
            func(s, 0, "");
//            for (int j = 0; j < list.size(); j++) {
//                System.out.println(j+1+" "+list.get(j));
//            }
            System.out.println(rs);
//            System.out.println(set.get(n-1));
        }
    }
    public static void func(String s, int index, String get){
        if (!rs.equals("")) return;
        if (index==s.length()){
            number++;
//            System.out.println(n+" "+number +":"+get);
            if (number==n){
//                System.out.println(n+" "+number +":"+get);
                rs = get;
            }
            return;
        }
        if (s.charAt(index)=='x'){
            get += "x";
            func(s, index+1, get);
        } else {
            int temIndex = index;
            while (temIndex<s.length() && s.charAt(temIndex)=='*'){
                temIndex++;
            }
            func(s, temIndex, get);
            for (int i = 0; i < m*(temIndex-index); i++) {
                get += "y";
                func(s, temIndex, get);
            }
        }
    }
}
