package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;

public class T21相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA!=nodeB) {
            nodeA = nodeA==null ? headB:nodeA.next;
            nodeB = nodeB==null ? headA:nodeB.next;
        }
        return nodeA;
    }
}
