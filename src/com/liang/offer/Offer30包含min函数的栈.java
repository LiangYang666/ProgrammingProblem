package com.liang.offer;

import java.util.Stack;

public class Offer30包含min函数的栈 {

}

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minValues;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minValues = new Stack<>();

    }

    public void push(int x) {
        if(minValues.empty() || x<=minValues.peek()){
            minValues.push(x);
        }
        stack.push(x);

    }

    public void pop() {
        int value = stack.pop();
        if(!minValues.empty()){
            if(value==minValues.peek()){
                minValues.pop();
            }
        }
    }

    public int top() {
        return stack.peek();

    }

    public int min() {
        return minValues.peek();
    }
}
