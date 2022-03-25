package com.liang.剑指offerI;

import com.liang.utils.ListNode;

public class Offer18删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre= null;
        ListNode cur = head;
//        ListNode next = head.next;
        if(head.val==val)   return head.next;
        while (cur!=null){
            if(cur.val==val){
                pre.next = cur.next;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
