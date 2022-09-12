package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;

public class T31重排链表 {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null){
            slow = slow.next;
            if (fast.next==null){
                break;
            }
            fast = fast.next.next;
        }
        ListNode node = slow;
        ListNode last = null;
        while (node!=null){
            ListNode next = node.next;
            node.next = last;
            last = node;
            node = next;
        }
        ListNode nodeA = head;
        ListNode nodeB = last;
        while (nodeB!=null){
            ListNode nextA = nodeA.next;
            ListNode nextB = nodeB.next;
            nodeA.next = nodeB;
            nodeB.next = nextA;
            nodeA = nextA;
            nodeB = nextB;
        }
        if (nodeA!=null){
            nodeA.next = null;
        }
    }
}
