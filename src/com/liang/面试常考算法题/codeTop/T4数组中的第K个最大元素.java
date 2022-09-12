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
public class T4数组中的第K个最大元素 {
    
    public int findKthLargest(int[] nums, int k) {
        k = nums.length-k;
        quickKSort(nums, 0, nums.length-1, k);
        return nums[k];
    }
    public void quickKSort(int[] arr, int low, int high, int k){
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int temp = arr[low];
        while (i < j) {
            while (temp <= arr[j] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;
        if (k==i){
            return;
        } else if (k<i){
            quickKSort(arr, low, i-1, k);
        } else {
            quickKSort(arr, i+1, high, k);
        }
    }

}
