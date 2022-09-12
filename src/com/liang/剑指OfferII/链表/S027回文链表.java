package com.liang.剑指OfferII.链表;

import com.liang.utils.ListNode;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.剑指OfferII.链表
 * @ClassName: S027回文链表
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2021/12/24 10:27
 * @Version: 1.0
 */
public class S027回文链表 {

    public boolean isPalindrome(ListNode head) {
        ListNode l1 = head;
        ListNode middle = findMiddle(head);
        ListNode l2 = middle.next;
        middle.next = null;
        l2 = reverseList(l2);
        while (l1!=null && l2!=null){
            if (l1.val!=l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

