package com.liang.面试常考算法题.真题;

import java.util.ArrayList;
import java.util.LinkedList;

public class 简单栈 {
    public static void main(String[] args) {
        SimpleStack stack = new SimpleStack();
        stack.push(3);
        stack.push(2);
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
    }
}
class SimpleStack{
    LinkedList<Integer> stack;
    ArrayList<Integer> queue;
    public SimpleStack(){
        stack = new LinkedList<>();
        queue = new ArrayList<>();
    }
    public int pop(){
        if (stack.isEmpty())    return -1;
        Integer t = stack.removeLast();
//        queue.remove(t);
        if (queue.get(queue.size()-1)==t)   queue.remove(queue.size()-1);
        return t;
    }
    public void push(int n){
        stack.addLast(n);

        if (queue.size()==0 || queue.get(queue.size()-1)>=n){
            queue.add(n);
        }
    }
    public int min(){
        if (stack.isEmpty())    return -1;
        return queue.get(0);
    }

}