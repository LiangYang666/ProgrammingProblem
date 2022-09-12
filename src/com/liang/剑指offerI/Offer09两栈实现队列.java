package com.liang.剑指offerI;

import java.util.Stack;

class Offser09两栈实现队列 {
    public static void main(String[] args) {

        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}

class CQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    public void appendTail(int val){
        stack1.push(val);
    }
    public int deleteHead(){
        while (stack1.isEmpty()==false){
            stack2.push(stack1.pop());
        }
        if(stack2.isEmpty()){
            return -1;
        }else {
            int r = stack2.pop();
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return r;
        }

    }
}

