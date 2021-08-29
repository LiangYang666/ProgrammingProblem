package com.liang.offer;

import com.liang.utils.ListNode;

import java.util.Stack;

public class Offer24反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode l=null, r=head;
        while (r!=null){
            ListNode next = r.next;
            r.next = l;
            l = r;
            r = next;
        }
        return l;
    }
}
