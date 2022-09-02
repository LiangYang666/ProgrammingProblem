package com.liang.笔试真题.广联达;

import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            s[sc.nextInt()] = i;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addLast(0);
        for (int i = 1; i < n+1; i++) {
            int p = sc.nextInt();
            int id = s[p];
            while (stack.getLast()>id){
                stack.removeLast();
            }
            stack.addLast(id);
        }
        System.out.println(n-stack.size()+1);
    }
}
