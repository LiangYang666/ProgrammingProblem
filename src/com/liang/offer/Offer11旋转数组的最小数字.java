package com.liang.offer;

public class Offer11旋转数组的最小数字 {
    static int[] a = {6,7,8, 9, 10,1,2,3};
    public static void main(String[] args) {
        System.out.println(minArray(a));
    }

    static
    public int minArray(int[] numbers) {
        if(numbers.length==0) return -1;
        if(numbers.length==1)   return numbers[0];
        int left = 0;
        int right = numbers.length-1;

        while(left<right){
            int middle = (left+right)/2;
            if(numbers[middle]>numbers[right]){
                left = middle+1;
            }else if(numbers[left]>numbers[middle]){
                right = middle;
            }else {
                right--;
            }
        }
        return numbers[left];
    }
}
