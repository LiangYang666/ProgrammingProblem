package com.liang.面试知识点.jvm.OOM;

import java.util.ArrayList;

public class HeapOOM {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        long a = 0;
        while (true){
            for (int i = 0; i < 100; i++) {
                list.add(new String("abc"));
            }
            System.out.println(a++);
        }
    }
}
