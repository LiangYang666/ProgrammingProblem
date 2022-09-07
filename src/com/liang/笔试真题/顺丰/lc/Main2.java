package com.liang.笔试真题.顺丰.lc;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }
        int rs = 0;
        while (queue.size()>=m){
            int[] temp = new int[m];
            for (int i = 0; i < m; i++) {
                temp[i] = queue.poll();
            }
            int minus = temp[m-1];
            if (queue.size()>0){
                Integer peek = queue.peek();
                minus = (minus-peek+1);
            }
            rs+=minus;
            for (int i = 0; i < m; i++) {
                temp[i]-=minus;
                if (temp[i]>0){
                    queue.add(temp[i]);
                }
            }
        }
        System.out.println(rs);
    }
}
