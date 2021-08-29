package com.liang.offer;

import com.liang.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.liang.offer.Offer11旋转数组的最小数字.a;

public class Offer06从尾到头打印链表 {
    public static void main(String[] args) {
        Integer a[] = {1,2,3};
    }
    static
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] r = new int[size];
        for (int i = 0; i < size; i++) {
            r[i] = stack.pop();
        }
        return r;
    }
}

