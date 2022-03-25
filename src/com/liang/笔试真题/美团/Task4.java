package com.liang.笔试真题.美团;

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[10005];
        Arrays.fill(nums, -1);
        for (int i = 0; i < m; i++) {
            nums[i] = scanner.nextInt()-1;
        }
        int now=0;
        int rs=0;
        for (int i = 0; i < m; i++) {
            if (nums[i]!=now) continue;
            rs++;
            int j = i;
            int temp=0;
            while (j<m){
                temp |= (1<<nums[j]);
                if (temp==((1<<n)-1)) break;
                j++;
            }
            now = nums[j];
        }
        System.out.println(rs);
    }
}
