package com.liang.面试知识点.sort;

import java.util.Arrays;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.sort
 * @ClassName: test
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/4/1 16:09
 * @Version: 1.0
 */
public class test {
    public static void main(String[] args) {
        int[]  arr = {9,2,3,4,5};
        int oddTotal = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2!=0){
                oddTotal++;
            }
        }

        int oddIndex = 0;
        int oushuIndex = oddTotal;
        while (oddIndex<oddTotal || oushuIndex< arr.length){
            int i = oddIndex;
            int min = arr[i];
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(j>=oddTotal && j<oushuIndex ){
                    continue;
                }
                if (arr[j]<min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (arr[minIndex]%2==0){
                int swap = arr[minIndex];
                arr[minIndex] = arr[oushuIndex];
                arr[oushuIndex] = swap;
                oushuIndex++;
            } else {
                int swap = arr[minIndex];
                arr[minIndex] = arr[oddIndex];
                arr[oddIndex] = swap;
                oddIndex++;
            }
        }
        // 插入排序


        System.out.println(Arrays.toString(arr));
    }
}
