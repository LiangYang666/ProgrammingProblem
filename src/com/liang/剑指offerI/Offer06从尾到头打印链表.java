package com.liang.剑指offerI;

import com.liang.utils.ListNode;

import java.util.Stack;

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

