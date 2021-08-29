package com.liang.sort;

import java.util.Arrays;

public class Sort {
    public Sort() {
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr1 = {1,5,4,5,4,6,2,6,4,5,1,7,9,5,6,4,34,3,88,43,9,75,2};
//        sort.insertionSort(arr1);
        sort.quickSort(arr1, 0, arr1.length-1);
        System.out.println(Arrays.toString(arr1));
    }
    public void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if(array[j]<array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    public void quickSort(int[] arr, int low, int high){
        int i, j, temp;
        if(low>=high){
            return;
        }
        i=low;
        j=high;
        temp=arr[low];
        while(i<j){
            while(temp<=arr[j] && i<j){
                j--;
            }
            while(temp>=arr[i] && i<j){
                i++;
            }
            if(i<j){
                int swap = arr[j];
                arr[j] = arr[i];
                arr[i] = swap;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr, low, i-1);
        quickSort(arr, i+1, high);
    }
}
