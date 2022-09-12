package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;

import java.util.ArrayList;

public class T5K个一组反转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        int i = 0;
        while (head !=null){
            if (i%k==0){
                listNodes.add(head);
            }
            head = head.next;
            i++;
        }
        ListNode tail = null;
        if (i%k!=0){
            tail = listNodes.remove(listNodes.size()-1);
        }
        for (int j = 0; j < listNodes.size(); j++) {
            ListNode node = reverseK(listNodes.get(j), k);
            listNodes.set(j, node);
        }
        listNodes.add(tail);
        for (int j = 0; j < listNodes.size()-1; j++) {
            ListNode temp = listNodes.get(j);
            for (int l = 0; l < k-1; l++) {
                temp = temp.next;
            }
            temp.next = listNodes.get(j+1);
        }
        return listNodes.get(0);
    }

    public ListNode reverseK(ListNode head, int k){
        ListNode now = head;
        ListNode next;
        ListNode pre = null;
        int n = 0;
        for (int i = 0; i < k; i++) {
            next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
}
