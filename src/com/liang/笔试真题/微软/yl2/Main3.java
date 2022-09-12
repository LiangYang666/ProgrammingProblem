package com.liang.笔试真题.微软.yl2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main3 {

    public int solution(int[] A, int[] B) {
        // write your code in Java 8 (Java SE 8)
        int minNum = Integer.MAX_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i]==B[i]){
                queue.remove(A[i]);
            } else if (A[i]>B[i]){
                if (!queue.contains(B[i])){
                    queue.add(B[i]);
                }
            } else {
                if (!queue.contains(A[i])){
                    queue.add(A[i]);
                }
            }
        }
        if (queue.isEmpty())    return -1;
        return queue.peek();
    }
}
