package com.liang.笔试真题.蔚来.hb;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.笔试真题.蔚来.hb
 * @ClassName: Main3
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/8/30 15:15
 * @Version: 1.0
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] isA = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (sc.next().equals("A"))  isA[i] = true;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            list.addLast(i);
        }
        for (int i = 0; i < m; i++) {
            if (isA[i]){
                list.addLast(list.remove(0));
            } else {
                Collections.reverse(list);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
