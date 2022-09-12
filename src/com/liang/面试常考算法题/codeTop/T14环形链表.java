package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;


public class T14环形链表 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null){
            slow = slow.next;
            if (fast.next==null){
                return false;
            }
            fast = fast.next.next;
            if (fast==slow){
                return true;
            }
        }
        return false;
    }
}
