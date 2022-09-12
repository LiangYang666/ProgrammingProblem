package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;

public class T44删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next!=null){
            int x = temp.next.val;
            if (temp.next.next!=null && x==temp.next.next.val){
                ListNode tt = temp.next.next;
                while (tt!=null && tt.val==x){
                    tt = tt.next;
                }
                temp.next = tt;
            }else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }
}
