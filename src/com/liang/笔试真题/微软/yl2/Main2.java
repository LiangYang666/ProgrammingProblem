package com.liang.笔试真题.微软.yl2;

import java.util.Arrays;

public class Main2 {



    static
    public int solution(int[] A, int M) {
        // write your code in Java 8 (Java SE 8)
        Arrays.sort(A);
        int n = A.length;
        boolean[] visited = new boolean[n];
        int maxSUm = 1;
        for (int i = 0; i < n; i++) {
            int maxSumTemp = 1;
            if (visited[i]) continue;
            int last = A[i];
            for (int j = i+1; j < n; j++) {
                int temp = A[j];
                if ((temp-last)%M==0){
                    visited[j] = true;
                    maxSumTemp ++;
                }
            }
            maxSUm = Math.max(maxSUm, maxSumTemp);
        }
        return maxSUm;
    }
}
