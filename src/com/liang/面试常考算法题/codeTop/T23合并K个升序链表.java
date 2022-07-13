package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;

public class T23合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dumpHead = new ListNode();
        ListNode now = dumpHead;
        int n = 0;
        while (n!=lists.length){
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            n = lists.length;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i]!=null){
                    n--;
                    if (lists[i].val<minValue){
                        minIndex = i;
                        minValue = lists[i].val;
                    }
                }
            }
            if (minIndex>=0){
                now.next = lists[minIndex];
                now = now.next;
                lists[minIndex] = lists[minIndex].next;
            }
        }
        return dumpHead.next;
    }
}
