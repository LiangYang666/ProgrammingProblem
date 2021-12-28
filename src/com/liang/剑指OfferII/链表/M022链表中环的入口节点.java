package com.liang.剑指OfferII.链表;

import com.liang.utils.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.剑指OfferII.链表
 * @ClassName: M022链表中环的入口节点
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2021/12/23 8:35
 * @Version: 1.0
 */
public class M022链表中环的入口节点 {
    public ListNode detectCycle(ListNode head){
        HashSet<ListNode> nodes = new HashSet<>();
        ListNode node = head;
        while (!nodes.contains(node) && node!=null){
            nodes.add(node);
            node = node.next;
        }
        return node;
    }
    public ListNode detectCycle1(ListNode head){
        ListNode slow = new ListNode(0);
        ListNode fast = new ListNode(0);
        ListNode ptr = new ListNode(0);
        slow.next = head;
        fast.next = head;
        ptr.next = head;
        while (slow!=fast && fast!=null){
            slow = slow.next;
            if (fast.next==null){
                return null;
            } else {
                fast = fast.next.next;
            }
        }
        if (slow==null || fast==null)   return null;
        while (ptr!=slow){
            ptr = ptr.next;
            slow = slow.next;
        }
        return ptr;
    }
}
