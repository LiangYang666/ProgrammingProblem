package com.liang.剑指offerI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DOffer41数据流中的中位数_大小顶堆 {
    MedianFinder medianFinder = new MedianFinder();


}
class MedianFinder2{    //优先队列

    private PriorityQueue<Integer> numsA;   //大顶堆存小的数
    private PriorityQueue<Integer> numsB;   //小顶堆存大的数
    private int numsTotal;

    /** initialize your data structure here. */
    public MedianFinder2() {
        numsA = new PriorityQueue<>((x, y)->(y-x));
        numsB = new PriorityQueue<>();
        numsTotal = 0;
    }

    public void addNum(int num) {
        if(numsTotal%2==0){
            numsB.add(num);
            numsA.add(numsB.poll());
        }else {
            numsA.add(num);
            numsB.add(numsA.poll());
        }
        numsTotal++;

    }

    public double findMedian() {
        if(numsTotal>0)
            return (numsTotal%2==0)?(numsA.peek()+numsB.peek())/2.0:(double)(numsA.peek());
        else
            return 0;
    }


}

class MedianFinder {    //列表存储 二分查找插入
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        Integer[] arr = {1,2,4,4,5,6,6,7,8,9,10};
        System.out.println(medianFinder.binarySearch(Arrays.asList(arr), 3));
    }
    private ArrayList<Integer> nums;
    public int binarySearch(List<Integer> array, int num){
        int i=0, j=array.size()-1, m;
        while(i<=j){
            m = (i+j)/2;
            if(array.get(m)==num){
                return m;
            } else if(array.get(m)>num){
                j = m-1;
            } else if(array.get(m)<num){
                i = m+1;
            }
        }
        return i-1;
    }

    /** initialize your data structure here. */
    public MedianFinder() {
        nums = new ArrayList<>();
    }

    public void addNum(int num) {
        if(nums.isEmpty()){
            nums.add(num);
        }else {
            int insertIndex = binarySearch(nums, num)+1;
            nums.add(insertIndex, num);
        }
    }

    public double findMedian() {
        int m = nums.size()/2;
        if(nums.size()%2==0){
            return (double)(nums.get(m-1)+nums.get(m))/2.0;
        }else {
            return (double)nums.get(m);
        }
    }
}