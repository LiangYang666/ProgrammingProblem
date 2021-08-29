package com.liang.offer;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Offer40最小的k个数 {
    static
    public int[] getLeastNumbers(int[] arr, int k) {
//        for (int i = 0; i < arr.length; i++) {
//            int min_value = arr[i];
//            int min_j = i;
//            for (int j = i; j < arr.length; j++) {
//                if(min_value>arr[j]){
//                    min_j = j;
//                    min_value = arr[j];
//                }
//            }
//            arr[min_j] = arr[i];
//            arr[i] = min_value;
//        }
//        return Arrays.copyOfRange(arr,0, k);
        Offer40最小的k个数 sort = new Offer40最小的k个数();
//        sort.quickSort(arr, 0, arr.length-1);
        sort.quickKMin(arr, 0, arr.length-1, k);
        return Arrays.copyOfRange(arr, 0, k);


    }
    public void quickKMin(int[] arr, int left, int right, int k){
        if(left>=right) return;
        int i=left, j=right, temp=arr[i];
        while(i<j){
            while(temp<=arr[j] && i<j){
                j--;
            }
            while(temp>=arr[i] && i<j){
                i++;
            }
            if(i<j){
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        if(i==k){
            return;
        }
        if(i>k){
            quickKMin(arr, left, i-1, k);
        }
        if(i<k){
            quickKMin(arr, i+1, right, k);
        }
    }
    public void quickSort(int[] arr, int left, int right){
        if(left>=right) return;
        int i=left, j=right, temp=arr[i];
        while(i<j){
            while (temp<=arr[j] && i<j){
                j--;
            }
            while (temp>=arr[i] && i<j){
                i++;
            }
            if(i<j){
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort(arr, left, i-1);
        quickSort(arr, i+1, right);
    }
    public static void main(String[] args) {
        int[] a = {5,12,3,6,8,4,2,1,6,4};
        System.out.println(Arrays.toString(getLeastNumbers(a, 7)));
//        Offer40最小的k个数 sort = new Offer40最小的k个数();
//        sort.quickKMin(a, 0, a.length-1, 3);
//        System.out.println(Arrays.toString(Arrays.copyOfRange(a, 0, 3)));
    }

}
class Offer40最小的k个数_堆排序{
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> minK = new PriorityQueue<>((x,y)->(y-x));
        int total =0;
        for (int i = 0; i < arr.length; i++) {
            minK.add(arr[i]);
            if(minK.size()>k){
                minK.poll();
            }
        }
        int[] ints = new int[minK.size()];
        int i = 0;
        for (Integer integer : minK) {
            ints[i++] = integer;
        }
        return ints;
//        Integer[] integers = (Integer[]) minK.toArray();
//        int[] rs = (int[]) minK.toArray();
//        return Arrays.asList(integers).stream().mapToInt(Integer::valueOf).toArray();
    }
}
