package com.liang.笔试真题.深信服;

import com.liang.utils.ListNode;
import org.w3c.dom.ls.LSException;

import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        System.out.println(new Main3());


    }

    public ListNode reverseBetween (ListNode head) {
        // write code here
        ListNode temp = new ListNode(-1);
        ListNode dumy = temp;
        temp.next = head;
        ListNode l = null;
        ListNode r = null;
        while (temp!=null){
            if (temp.next!=null && temp.next.val==3){
                l = temp;
            }
            if (temp.val==6){
                r = temp.next;
            }
            temp = temp.next;
        }
        l.next = reverseList(l, r);
        return dumy.next;
    }
    public ListNode reverseList(ListNode left, ListNode right){
        ListNode last = right;
        ListNode temp = left.next;
        while (temp!=right){
            ListNode next = temp.next;
            temp.next = last;
            last = temp;
            temp = next;
        }
        return last;
    }
}
