package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;

public class T27反转链表II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dumpHead = new ListNode();
        ListNode temp = dumpHead;
        temp.next = head;
        for (int i = 0; i < left-1; i++) {
            temp = temp.next;
        }
        temp.next = reverseK(temp.next, right-left+1);
        return dumpHead.next;
    }
    public ListNode reverseK(ListNode head, int k){
        ListNode last = null;
        for (int i = 0; i < k; i++) {
            ListNode next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
        ListNode temp = last;
        for (int i = 0; i < k-1; i++) {
            temp = temp.next;
        }
        temp.next = head;
        return last;
    }
}
