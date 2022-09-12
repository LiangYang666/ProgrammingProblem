package com.liang.剑指offerI;

import com.liang.utils.ListNode;

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
