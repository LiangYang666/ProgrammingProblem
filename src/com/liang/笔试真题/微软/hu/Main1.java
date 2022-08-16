package com.liang.笔试真题.微软.hu;

import java.util.PriorityQueue;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 70,100}, 4));
    }

    static
    int solution(int[] A, int N){
        if (A.length==0)    return 0;
        double total = 0;
        PriorityQueue<Double> list = new PriorityQueue<>(N, (a, b) -> (int)((b-a)*100));
        for (int i = 0; i < A.length; i++) {
            total += A[i];
            list.add(A[i]*1.0);
        }
        int rs = 0;
        double target = total/2;
        while (total>target){
            Double poll = list.poll();
            poll/=2;
            total-=poll;
            rs++;
            list.add(poll);
        }
        return rs;
    }
}
