package com.liang.面试常考算法题.codeTop;

import java.util.Stack;

public class T34用栈实现队列 {

}
class MyQueue {
    Stack<Integer> stackA;
    Stack<Integer> stackB;
    int size;

    public MyQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
        size = 0;
    }

    public void push(int x) {
        while (!stackB.empty()){
            stackA.push(stackB.pop());
        }
        stackA.push(x);
    }

    public int pop() {
        while (!stackA.empty()){
            stackB.push(stackA.pop());
        }
        return stackB.pop();
    }

    public int peek() {
        while (!stackA.empty()){
            stackB.push(stackA.pop());
        }
        return stackB.peek();
    }

    public boolean empty() {
        return stackB.empty() && stackA.empty();
    }
}
