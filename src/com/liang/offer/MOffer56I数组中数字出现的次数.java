package com.liang.offer;

import java.util.Arrays;

public class MOffer56I数组中数字出现的次数 {
    public static void main(String[] args) {
        int[] arr = {1,2, 4, 4, 9, 9};
        System.out.println(Arrays.toString(singleNumbers(arr)));

    }
    static
    public int[] singleNumbers(int[] nums) {
        int n = nums.length;
        int xy = 0;
        for (int i = 0; i < n; i++) {
            xy ^= nums[i];
        }
        int m=1;
        while((xy&m)==0){
            m <<= 1;
        }
        int x=0, y=0;
        for (int i = 0; i < n; i++) {
            if((nums[i]&m)==0){
                x ^= nums[i];
            }else {
                y ^= nums[i];
            }
        }

        return new int[] {x, y};
    }
}
