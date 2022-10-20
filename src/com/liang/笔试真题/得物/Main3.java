package com.liang.笔试真题.得物;

import java.util.Scanner;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.笔试真题.得物
 * @ClassName: Main3
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/10/1 15:44
 * @Version: 1.0
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    public boolean find (int[][] array, int target) {
        // write code here
        int i = 0;
        int j = array[0].length-1;
        while (i < array.length && j >= 0) {
            if (array[i][j]>target){
                j--;
            } else if (array[i][j]<target){
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
