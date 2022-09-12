package com.liang.笔试真题.广联达;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main1Copy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sidx = new int[n+1];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            sidx[s] = i+1;
        }
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int id = sidx[p];
            while (st.peek()>id){
                st.pop();
            }
            st.add(id);
        }
        int rs = n-st.size()+1;
        System.out.println(rs);
    }
}


