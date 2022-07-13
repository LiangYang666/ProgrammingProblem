package com.liang.面试常考算法题.codeTop;

public class T17合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < m; i++) {
            nums1[m+n-i-1] = nums1[m-i-1];
        }
        int i1 = n;
        int i2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (i2>=n || (i1<m+n && nums1[i1]<=nums2[i2])){
                nums1[i] = nums1[i1++];
            } else {
                nums1[i] = nums2[i2++];
            }
        }
    }
}
