package com.liang.剑指OfferII.链表;

import com.liang.utils.ListNode;

import java.util.ArrayList;

public class M026重排链表 {
    public void reorderList1(ListNode head) {       // 线性表存储
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head!=null){
            nodes.add(head);
            head=head.next;
        }
        int l = 0;
        int r = nodes.size()-1;
        if (nodes.size()<=2)    return;

        while (l<r){
            nodes.get(l).next=nodes.get(r);
            nodes.get(r).next = nodes.get(l+1);
            l++;
            r--;
        }
        if (l==r)  {
            nodes.get(r+1).next=nodes.get(r);
            nodes.get(r).next = null;
        } else {
            nodes.get(l).next = null;
        }
    }

    public void reorderList(ListNode head){
        ListNode l1 = head;
        ListNode middle = findMiddleNode(head);
        ListNode l2 = middle.next;
        middle.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);


    }
    public ListNode findMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public void mergeList(ListNode l1, ListNode l2){
        while (l1!=null && l2!=null){
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            l1.next = l2;
            l2.next = l1Next!=null?l1Next:l2.next;
            l1 = l1Next;
            l2 = l2Next;
        }
    }

}
