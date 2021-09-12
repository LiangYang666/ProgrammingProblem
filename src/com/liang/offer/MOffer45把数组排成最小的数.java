package com.liang.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MOffer45把数组排成最小的数 {
    public static void main(String[] args) {
        int[] nums = {1,32,4, 3, 31};
        System.out.println(minNumber(nums));

    }
    static
    public String minNumber(int[] nums) {
        Integer[] numbers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = nums[i];
        }
        Arrays.sort(numbers, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s1+s2).compareTo(s2+s1);
            }
        });
//        System.out.println(Arrays.toString(numbers));
        String rs = "";
        for (Integer number : numbers) {
            rs = rs.concat(String.valueOf(number));
        }
        return rs;
    }
}