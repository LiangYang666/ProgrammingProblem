package com.liang.笔试真题.oppo;

import com.liang.utils.ListNode;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    public ListNode combineTwoDisorderNodeToOrder (ListNode node1, ListNode node2) {
        // write code here
        ListNode dumy = new ListNode(-1);
        ListNode dumyA = new ListNode(-1);
        dumyA.next = node1;
        ListNode temp = dumyA;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = node2;
        temp = dumyA;
        ListNode rs = dumy;

        while (dumyA.next!=null){
            ListNode minNodePre = dumyA;
            int min = Integer.MAX_VALUE;
            temp = dumyA;
            while (temp.next!=null){
                if (temp.next.val<min){
                    minNodePre = temp;
                    min = temp.next.val;
                }
                temp = temp.next;
            }
            rs.next = minNodePre.next;
            rs = rs.next;
            minNodePre.next = minNodePre.next.next;
        }
        return dumy.next;
    }
}
