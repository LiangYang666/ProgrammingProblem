package com.liang.Interview;

import java.util.Arrays;

public class MInterview面试题17_14最小K个数 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        System.out.println(Arrays.toString(smallestK(arr, 4)));

    }
    static
    public int[] smallestK(int[] arr, int k) {
        int[] rs = new int[k];
        int n = arr.length;
        quickSort(arr, 0, n-1, k);
        for (int i = 0; i < k; i++) {
            rs[i] = arr[i];
        }
        return rs;
    }
    static
    void quickSort(int[] arr, int begin, int end, int k){
        if(begin>=end) return;
        int l = begin;
        int r = end;
        while(l<r){
            while(l<r && arr[r]>arr[begin]){
                r--;
            }
            while(l<r && arr[l]<=arr[begin]){
                l++;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
        int temp = arr[begin];
        arr[begin] = arr[r];
        arr[r] = temp;
//        System.out.println(temp);
//        System.out.println(Arrays.toString(arr));
        if(r==k || r==k-1){
            return;
        }
        if(r-1>=k)
            quickSort(arr, begin, r-1, k);
        if(r+1<=k)
            quickSort(arr, r+1, end, k);
    }
}
