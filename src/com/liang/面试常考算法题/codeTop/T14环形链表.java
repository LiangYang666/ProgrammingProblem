package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;


public class T14环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head==null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow!=fast){
            if (fast==null || fast.next==null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
