package com.liang.剑指OfferII.队列;

import java.util.LinkedList;

public class S041滑动窗口的平均值 {

}
class MovingAverage {

    private LinkedList<Integer> queue;
    private int size;
    private int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        sum = 0;
    }


    public double next(int val) {
        if (queue.size()==size){
            sum -= queue.poll();
        }
        sum += val;
        queue.add(val);
        return sum*1.0/(queue.size());
    }
}
