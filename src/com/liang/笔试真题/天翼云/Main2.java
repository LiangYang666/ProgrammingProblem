package com.liang.笔试真题.天翼云;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        String[] ss = s.split(",");
        ArrayList<Integer> oushu = new ArrayList<>();
        ArrayList<Integer> jishu = new ArrayList<>();
        for (int i = 0; i < ss.length; i++) {
            int t = Integer.parseInt(ss[i]);
            if (t % 2 == 0) {
                oushu.add(t);
            } else {
                jishu.add(t);
            }
        }
        oushu.addAll(jishu);
        for (int i = 0; i < oushu.size(); i++) {
            System.out.print(oushu.get(i));
            if (i!=oushu.size()-1)
                System.out.print(",");
        }
    }
}
