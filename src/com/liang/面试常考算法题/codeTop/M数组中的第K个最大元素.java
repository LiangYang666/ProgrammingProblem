package com.liang.面试常考算法题.codeTop;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.常考算法题.codeTop
 * @ClassName: M数组中的第K个最大元素
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/22 14:18
 * @Version: 1.0
 */
public class M数组中的第K个最大元素 {
    
    public int findKthLargest(int[] nums, int k) {
        topKOneSort(nums, k-1, 0, nums.length-1);
        return nums[k-1];
        
    }
    public void topKOneSort(int[] nums, int k, int low, int high){
        if (low>=high)  return;
        int temp = nums[low];
        int i = low;
        int j = high;
        while (i<j){
            while (temp>=nums[j] && i<j){
                j--;
            }
            while (temp<=nums[i] && i<j){
                i++;
            }
            if (i<j){
                int swap = nums[i];
                nums[i] = nums[j];
                nums[j] = swap;
            }
        }
        nums[low] = nums[i];
        nums[i] = temp;
        if(i<k) topKOneSort(nums, k, i+1, high);
        else if(i>k) topKOneSort(nums, k, low, i-1);
    }
}
