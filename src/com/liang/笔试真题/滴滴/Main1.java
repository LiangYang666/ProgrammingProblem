package com.liang.笔试真题.滴滴;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    // ?123 -->3123
    // 10? --> 102
    // 输入一个字符串由数字和?号组成，求这个数可能的最小值，第一位不能为0
    static int[] rs = null ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        rs = null;
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            if (s.charAt(i)=='?'){
                nums[i]=-1;
            }else
                nums[i] = s.charAt(i)-'0';
        }
        dfs(nums, 0, 0);

        for (int r : rs) {
            System.out.print(r);
        }
        System.out.println();
    }
    public static void dfs(int[] nums, int index, int has){
        if (index==nums.length || rs!=null){
            if (has==0 && rs==null){
//                System.out.println(Arrays.toString(nums));
                rs = Arrays.copyOf(nums, nums.length);
            }
            return;
        }
        if (nums[index]!=-1){
            has = (has*10+nums[index])%3;
            dfs(nums, index+1, has);
        } else {
            for (int i = 0; i < 10; i++) {
                if (index==0 && i==0){
                    continue;
                } else {
                    if ((index>0 && nums[index-1]==i) || ((index+1)<nums.length && nums[index+1]==i)){
                        continue;
                    }else {
                        nums[index] = i;
                        dfs(nums, index+1, (has*10+nums[index])%3);
                        nums[index] = -1;
                    }
                }
            }
        }
    }
}
