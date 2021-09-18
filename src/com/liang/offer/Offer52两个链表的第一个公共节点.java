package com.liang.offer;

import com.liang.utils.ListNode;

public class Offer52两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {   //方法一
        int m=0, n=0;
        ListNode p1=headA, p2=headB;
        while(p1!=null){
            p1 = p1.next;
            m++;
        }
        while (p2!=null){
            p2 = p2.next;
            n++;
        }
        System.out.println(m);
        System.out.println(n);
        int err = m-n;
        System.out.println(err);
        while (err>0) {
            headA = headA.next;
            err--;
        }
        while (err<0){
            headB = headB.next;
            err++;
        }
        while (headA!=null){
            if(headA==headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {  //方法二 双指针法
        ListNode pA=headA, pB=headB;
        if(pA==null || pB==null)    return null;
        while(true){
            if(pA==null && pB==null){
                break;
            } else if(pA==null){
                pA=headB;
            } else if(pB==null){
                pB=headA;
            }
            if(pA==pB){
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }
}
