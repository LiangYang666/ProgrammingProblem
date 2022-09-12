package com.liang.normal;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.normal
 * @ClassName: Index703二分查找
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/3/25 23:28
 * @Version: 1.0
 */
public class Index703二分查找 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int m=0;
        while (l<r){
            m = (l+r)/2;
            if (target<=nums[m]){
                r = m;
            } else {
                l = m+1;
            }
        }
        if (nums[m]==target)    return m;
        return -1;
    }
}
