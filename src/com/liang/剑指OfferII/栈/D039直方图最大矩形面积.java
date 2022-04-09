package com.liang.剑指OfferII.栈;

import java.util.LinkedList;

public class D039直方图最大矩形面积 {
    public static void main(String[] args) {

    }
    static
    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = heights.length;
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while (stack.getFirst()!=-1 && heights[stack.getFirst()]>=heights[i]){
                int left = stack.pop();
                int height = heights[left];
                int width = i-stack.getFirst()-1;
                result = Math.max(height*width, result);
            }
            stack.push(i);
        }
        while (stack.getFirst()!=-1){
            int left = stack.pop();
            int height = heights[left];
            int width = n-stack.getFirst()-1;
            result = Math.max(height*width, result);
        }
        return result;
    }

}
