package com.liang.面试常考算法题.面试;

import java.util.Arrays;
import java.util.LinkedList;

public class Main1 {
    // 华为一面
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println( formatePath("/home//foo/"));

    }
    public static String formatePath(String path){
        LinkedList<String> stack = new LinkedList<>();
        String[] paths = path.split("/");
        int n = paths.length;
        for (int i = 0; i < n; i++) {
            String temp = paths[i];
            if (temp.equals("") || temp.equals(".")){
                continue;
            } else if(temp.equals("..")){
                if (stack.size()>0){
                    stack.removeLast();
                }
            } else {
                stack.addLast(temp);
            }
        }
        StringBuilder rs = new StringBuilder("/");
        while (stack.size()>0){
            rs.append(stack.removeFirst());
            if(stack.size()>0){
                rs.append("/");
            }
        }
        return rs.toString();
    }
}
