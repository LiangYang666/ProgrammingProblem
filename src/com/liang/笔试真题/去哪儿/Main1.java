package com.liang.笔试真题.去哪儿;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.笔试真题.去哪儿
 * @ClassName: Main1
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/9/7 13:50
 * @Version: 1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    int maxGet = 0;
    public int maxScore (int energy, int[][] actions) {
        // write code here
//        Arrays.sort(actions, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                double a = o1[1] * 1.0 / o1[0];
//                double b = o2[1]*1.0 / o2[0];
//                if (a>b){
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        });
        dfs(energy, actions, 0, 0);
        return maxGet;


    }
    public void dfs(int energy, int[][] actions, int get,int index){
        if (energy<0){
            return;
        } else {
            maxGet = Math.max(maxGet, get);
        }
        if (index==actions.length)  return;
        dfs(energy-actions[index][0], actions, get+actions[index][1], index+1);
        dfs(energy, actions, get, index+1);
    }
}
