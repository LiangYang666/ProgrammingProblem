package com.liang.类别.树;

import com.liang.utils.TreeNode;

public class Index108将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dp(nums, 0, nums.length-1);
    }
    public TreeNode dp(int[] nums, int l, int r){
        if(l>r) return null;
        int m = (l+r)/2;
        return new TreeNode(nums[m], dp(nums, l, m-1), dp(nums, m+1, r));
    }

}
