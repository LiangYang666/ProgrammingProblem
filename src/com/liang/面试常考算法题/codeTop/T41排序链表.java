package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;

public class T41排序链表 {
    public ListNode sortList(ListNode head) {
        return mergeListSort(head, null);
    }
    public ListNode mergeListSort(ListNode start, ListNode end){
        if (start==null){
            return start;
        }
        if (start.next == end){
            start.next = null;
            return start;
        }
        ListNode slow = start;
        ListNode fast = start;
        while (fast!=end){
            if (fast.next==end){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode a = mergeListSort(start, slow);
        ListNode b = mergeListSort(slow, end);
        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead;
        while (a!=null && b!=null){
            if (a.val<=b.val){
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        if (a!=null){
            temp.next = a;
        }
        if (b!=null){
            temp.next = b;
        }
        return dummyHead.next;
    }
}
