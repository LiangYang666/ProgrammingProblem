package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;


public class T14环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head.next;
        while (fast!=slow){
            if (fast==null || fast.next==null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
