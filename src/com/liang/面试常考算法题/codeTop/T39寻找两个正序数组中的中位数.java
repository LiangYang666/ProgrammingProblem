package com.liang.面试常考算法题.codeTop;

public class T39寻找两个正序数组中的中位数 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4,5,6,7,8};
        System.out.println(findKthNumber(nums1, nums2, 5));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length+nums2.length;
        if (l%2==0){
            return (findKthNumber(nums1, nums2, l/2)+findKthNumber(nums1, nums2, l/2+1))/2.0;
        }else {
            return findKthNumber(nums1,nums2, l/2+1);
        }

    }
    static
    public int findKthNumber(int[] nums1, int[] nums2, int k){
        int stem1 = 0;
        int stem2 = 0;
        while (true){
            if (stem1>= nums1.length){
                return nums2[stem2+k-1];
            }else if(stem2>=nums2.length){
                return nums1[stem1+k-1];
            }
            if (k==1){
                return Math.min(nums1[stem1], nums2[stem2]);
            }
            int k1 = Math.min(stem1 + (k/2-1), nums1.length-1);
            int k2 = Math.min(stem2 + (k/2-1), nums2.length-1);
            if (nums1[k1]<=nums2[k2]){
                k -= (k1-stem1+1);
                stem1 = k1+1;
            } else {
                k -= (k2-stem2+1);
                stem2 = k2+1;
            }
        }
    }

}
