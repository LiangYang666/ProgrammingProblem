package com.liang.剑指OfferII.链表;

import com.liang.utils.ListNode;

public class M029排序的循环链表 {
    public ListNode insert(ListNode head, int insertVal) {
        if (head==null) {
            head =  new ListNode(insertVal);
            head.next = head;
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        if (cur==pre) {
            cur.next=new ListNode(insertVal, cur);
            return cur;
        }
        boolean first = true;
        while (true){
            if (pre.val<=insertVal){
                if (pre.val<=cur.val){
                    if (insertVal<=cur.val){
                        pre.next = new ListNode(insertVal, cur);
                        return head;
                    }
                } else {    //头节点
                    pre.next = new ListNode(insertVal, cur);
                    return head;

                }
            }
            if (cur.val>=insertVal && pre.val>cur.val){
                pre.next = new ListNode(insertVal, cur);
                return head;
            }
            if (!first && head==pre){
                pre.next = new ListNode(insertVal, cur);
                return head;
            }
            if (first)  first=false;
            pre = cur;
            cur = cur.next;

        }

    }
}

