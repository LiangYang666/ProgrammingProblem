package com.liang.剑指offerI;

import java.util.Arrays;
import java.util.HashSet;

public class Offer03数组找重复数字 {

    public static void main(String[] args) {
        int[] nums = {5,7,3,4,2,1,6,3,5};

        System.out.println(findRepeatNumber(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static public int findRepeatNumber(int[] nums) {
        if(nums.length==0)  return -1;
        HashSet<Integer> has = new HashSet<>();
        for (int i:nums) {
            if (has.contains(i)) {
                return i;
            }
            else{
                has.add(i);
            }
        }
        return -1;


    }
}
