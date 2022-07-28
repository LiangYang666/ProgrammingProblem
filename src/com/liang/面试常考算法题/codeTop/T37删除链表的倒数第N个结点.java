package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;

public class T37删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = new ListNode();
        ListNode right = left;
        left.next = head;

        while (right!=null) {
            if (n != -1) {
                n--;
            } else {
                left = left.next;
            }
            right = right.next;
        }
        left.next = left.next.next;
        return left.next;
    }
}
