package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;

public class T43两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead;
        int c = 0;
        while (l1!=null || l2!=null){
            if (l1!=null){
                c += l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                c += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(c%10);
            temp = temp.next;
            c /= 10;
        }
        if (c!=0){
            temp.next = new ListNode(c%10);
        }
        return dummyHead.next;
    }
}
