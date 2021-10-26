package com.liang.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MOffer59II队列的最大值 {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(9);
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(10);
        maxQueue.push_back(7);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }

}
class MaxQueue {
    private LinkedList<Integer> queue;
//    private LinkedList<Integer> maxValues;
    private int[] maxValues;
    private int left;
    private int right;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxValues = new int[10005];
        left = 0;
        right = 0;
    }

    public int max_value() {
        if(queue.isEmpty()) return -1;
        return maxValues[left];
    }

    public void push_back(int value) {
        queue.addLast(value);


        while (left<right){     //上下两种均可
            if(maxValues[right-1]<value){
                right--;
            } else {
                break;
            }
        }
        maxValues[right++] = value;

//        for (int i = left; i <= right; i++) {
//            if(maxValues[i]<value){
//                maxValues[i] = value;
//                for (int j = i+1; j < right; j++) {
//                    maxValues[j] = 0;
//                }
//                right = i+1;
//                break;
//            }
//        }
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        int a = queue.pop();
        if(a==maxValues[left]){
            left++;
        }
        return a;
    }
}