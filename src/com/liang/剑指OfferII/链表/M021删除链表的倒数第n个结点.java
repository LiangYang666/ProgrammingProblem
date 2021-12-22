package com.liang.剑指OfferII.链表;

import com.liang.utils.ListNode;

public class M021删除链表的倒数第n个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(0){};
        fakeHead.next = head;
        ListNode tempNode = fakeHead;
        ListNode preDeleteNode = fakeHead;
        int i = 0;
        while (tempNode.next!=null){
            tempNode = tempNode.next;
            i++;
            if (i==(n+1)){
                i--;
                preDeleteNode = preDeleteNode.next;
            }
        }
        preDeleteNode.next = preDeleteNode.next.next;
        return fakeHead.next;
    }
}
