package com.liang.leetcode.周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/4/24 下午5:41
 **/
public class Apr0424_6041多个数组求交集 {
    public static void main(String[] args) {
        System.out.println(intersection(new int[][]{{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}}));

    }
    static
    public List<Integer> intersection(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }
        int[] startIndex = new int[nums.length];
        ArrayList<Integer> rs = new ArrayList<>();
        System.out.println(Arrays.deepToString(nums));
        while(true){
            if (startIndex[0]>=nums[0].length)  break;
            int temp = nums[0][startIndex[0]++];
            int count=1;
            for (int i = 1; i < nums.length; i++) {
                int j = startIndex[i];
                while (j<nums[i].length && nums[i][j]<temp){
                    j++;
                }
                startIndex[i]=j;
                if (j< nums[i].length && nums[i][j]==temp){
                    count++;
                }
            }
            if (count==nums.length)    rs.add(temp);
        }
        return rs;
    }
}
