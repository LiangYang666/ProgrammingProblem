package com.liang.sort;

import java.util.Arrays;

public class Sort {
    public Sort() {
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr1 = {1,5,4,5,4,6,2,6,4,5,1,7,9,5,6,4,34,3,88,43,9,75,2};
//        sort.quickSort(arr1, 0, arr1.length-1);
//        sort.bubbleSort(arr1);
//        sort.selectSort(arr1);
//        sort.insertSort(arr1);
        sort.shellSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
    public void bubbleSort(int[] arr){
        for (int i = arr.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (arr[j]<arr[j-1]){
                    int swap = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = swap;
                }
            }
        }
    }
    public void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j]<min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            int swap = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = swap;
        }
    }
    public void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j]<arr[j-1]){
                    int swap = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = swap;
                }
            }
        }
    }
    public void shellSort(int[] arr){
        int step = arr.length;
        while ((step/=2)>0){
            for (int i = step; i < arr.length ; i++) {
                for (int j = i; j > step ; j--) {
                    if (arr[j]<arr[j-step]){
                        int swap = arr[j];
                        arr[j] = arr[j-step];
                        arr[j-step] = swap;
                    }
                }
            }
        }
    }

    public void quickSort(int[] arr, int low, int high){    //Top K n个
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

    public void heapSort(int[] arr){
        for (int i=arr.length/2-1;i>=0;i--){

        }
    }
    public void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i];
        for (int k = i*2+1; k < length; k=k*2+1) {
            if (k+1 < length && arr[k]<arr[k+1]){
                k++;
            }
            if (arr[k]>temp){
                arr[i] = arr[k];
                i=k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }



}
