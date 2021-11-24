package com.liang.剑指OfferII.整数;

public class S006排序数组中两个数字之和 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n-1; i++) {
            int j = haveTarget(numbers,target-numbers[i], i+1, n-1);
            if(j!=-1) return new int[] {i,j};
        }
        return new int[] {1,2};
    }
    public int haveTarget(int[] numbers, int target, int l, int r){
        while (l<=r){
            int m = (l+r)/2;
            if (target==numbers[m]){
//                System.out.println(target);
                return m;
            } else if(target<numbers[m]){
                r = m-1;
            } else{
                l = m+1;
            }
        }
        return -1;
    }

}
