package com.liang.笔试真题.大疆;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        while (sc.hasNextInt()){
            arr.add(sc.nextInt());
        }
        int[] dp = new int[arr.size()+1];
        dp[1] = arr.get(0);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-2]+ arr.get(i-1), dp[i-1]);
        }
        System.out.println(dp[dp.length-1]);
    }
}
