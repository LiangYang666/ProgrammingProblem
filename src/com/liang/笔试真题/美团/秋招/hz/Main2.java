package com.liang.笔试真题.美团.秋招.hz;

import com.liang.面试知识点.sort.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] bigger = new int[n+1];
        int[] lower = new int[n+1];
        for (int i = 0; i < n; i++) {
            bigger[i+1] = bigger[i];
            if (nums[i] >= 0) {
                bigger[i+1] += 1;
            }

            lower[n-i-1] = lower[n-i];
            if (nums[n-i-1]<=0){
                lower[n-i-1] += 1;
            }
        }
        for (int i = 0; i < n+1; i++) {
            lower[i]+=bigger[i];
        }
        Arrays.sort(lower);
        System.out.println(lower[0]);
    }
}
