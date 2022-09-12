package com.liang.面试常考算法题.codeTop;

import java.util.LinkedList;

public class T29接雨水 {
    public int trap(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();
        int rs = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.getLast()]<height[i]){
                int t = height[stack.removeLast()];
                if (!stack.isEmpty()){
                    int h = Math.min(height[stack.getLast()], height[i]);
                    rs += (i-stack.getLast()-1)*(h-t);
                }
            }
            stack.addLast(i);
        }
        return rs;
    }
}
