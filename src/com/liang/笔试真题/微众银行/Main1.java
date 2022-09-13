package com.liang.笔试真题.微众银行;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[] a = new int[n];
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = sc.next();
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()==o2.length()){
                    return -o1.compareTo(o2);
                }
                return o2.length()-o1.length();
            }
        });
//        for (int i = 0; i < n; i++) {
//            System.out.println(strings[i]);
//        }
        String[] get = Arrays.copyOf(strings, 3);
        Arrays.sort(get);
        String rs = "";
        for (int i = 2; i >= 0; i--) {
            rs+=get[i];
        }
        System.out.println(rs);
    }
}
