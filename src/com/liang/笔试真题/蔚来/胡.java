package com.liang.笔试真题.蔚来;

import java.util.HashSet;
import java.util.Scanner;

public class 胡 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] total = new int[26];
        for (int i = 0; i < s.length(); i++) {
            total[s.charAt(i)-'A']++;
        }
        int minNumber = Integer.MAX_VALUE;
        HashSet<Integer> cs = new HashSet<>();
        for (int i = 0; i < total.length; i++) {
            if (total[i]==0)    continue;
            if (total[i]<=minNumber){
                if (total[i]<minNumber){
                    minNumber = total[i];
                    cs = new HashSet<>();
                }
                cs.add(i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!cs.contains(s.charAt(i)-'A')){
                System.out.print(s.charAt(i));
            }
        }
        System.out.println();
    }
}
