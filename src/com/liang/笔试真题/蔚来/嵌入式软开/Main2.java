package com.liang.笔试真题.蔚来.嵌入式软开;

import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    public int count(int[] A, int n) {
        // write code here
//        LinkedList<Integer> stack = new LinkedList<>();
        int rs = 0;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j>0 && A[j-1]>A[j]){
                int swap = A[j-1];
                A[j-1] = A[j];
                A[j] = swap;
                rs++;
                j--;
            }
        }
        return rs;
    }
}
