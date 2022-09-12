package com.liang.笔试真题.大疆.lc;

import com.liang.类别.扫描线.DIndex391完美矩形;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = i;
        }
        int k = sc.nextInt();
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        for (int i = 1; i < n; i++) {
            if (nums[i][0]==nums[i-1][0]){
                if (nums[i][1]-nums[i-1][1]<= k){
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");
    }
}
