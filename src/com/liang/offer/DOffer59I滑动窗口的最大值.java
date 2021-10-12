package com.liang.offer;

import java.util.LinkedList;

public class DOffer59I滑动窗口的最大值 {
    public static void main(String[] args) {

    }
    static
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)  return new int[0];
        LinkedList<Integer> q = new LinkedList<Integer>();
        int l = 0;
        int[] rs = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if(i-l>=k){
                if(q.getFirst()==nums[l]){
                    q.removeFirst();
                }
                l++;
            }
            while(!q.isEmpty() && q.getLast()<nums[i]){
                q.removeLast();
            }
            q.addLast(nums[i]);

            if(i+1-k>=0){
                rs[i+1-k] = q.getFirst();
            }
        }
        return rs;
    }
}
