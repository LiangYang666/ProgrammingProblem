package com.liang.offer;

import com.liang.utils.ListNode;

public class Offer25合并两个排序的链表 {

    static
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode now = null;
        now = pre;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                now.next = l1;
                l1 = l1.next;
            }else {
                now.next = l2;
                l2 = l2.next;
            }
            now = now.next;
        }
        now.next = l1==null?l2:l1;
//        if(l1==null){
//            now.next = l2;
//        }else {
//            now.next = l1;
//        }
        return pre.next;
    }
}
