package com.liang.剑指offerI;

public class DOffer51数组中的逆序对 {
    int[] nums, tmp;
    int res;
    public int reversePairs(int[] nums) {
        res = 0;
        this.nums = nums;
        tmp = new int[nums.length];
        mergeSort(0, nums.length-1);
        return res;
    }
    void mergeSort(int l, int r){
        if (l>=r)   return;
        int m = (l+r)>>1;
        mergeSort(l, m);
        mergeSort(m+1, r);
        for (int i = l; i <= r; i++) {
            tmp[i] = nums[i];
        }
        int i=l, j=m+1;
        for (int k = l; k <= r; k++) {
            if(j==r+1||(i<m+1 && tmp[i]<=tmp[j])){
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
                res += m+1-i;
            }
        }
    }
}
