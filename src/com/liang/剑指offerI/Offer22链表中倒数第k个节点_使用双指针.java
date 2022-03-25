package com.liang.剑指offerI;

import com.liang.utils.ListNode;

public class Offer22链表中倒数第k个节点_使用双指针 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode r=head;
        ListNode l=head;
        for (int i = 0; i < k; i++) {
            r=r.next;
        }
        while (r!=null){
            r = r.next;
            l = l.next;
        }
        return l;
    }

}
