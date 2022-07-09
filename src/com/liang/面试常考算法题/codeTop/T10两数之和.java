package com.liang.面试常考算法题.codeTop;

import java.util.Arrays;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试常考算法题.codeTop
 * @ClassName: T10两数之和
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/7/7 8:56
 * @Version: 1.0
 */
public class T10两数之和 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
    static
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            int tt = target-nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (tt==nums[j]){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
