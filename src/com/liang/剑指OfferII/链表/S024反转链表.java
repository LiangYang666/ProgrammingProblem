package com.liang.剑指OfferII.链表;

import com.liang.utils.ListNode;

import java.util.ArrayList;

public class S024反转链表 {
    //存着 重新连接
    public ListNode reverseList2(ListNode head) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        if (head==null) return null;
        while (head!=null){
            nodes.add(head);
            head = head.next;
        }
        for (int i = nodes.size()-1; i > 0 ; i--) {
            nodes.get(i).next = nodes.get(i-1);
        }
        nodes.get(0).next = null;
        return nodes.get(nodes.size()-1);
    }
    //递归
    public ListNode reverseList(ListNode head) {
        ListNode rear=head;
        if (head==null) return null;
        while (rear.next!=null){
            rear = rear.next;
        }
        dfs(head);
        return rear;
    }
    public ListNode dfs(ListNode node){
        if (node.next != null) {
            ListNode t = dfs(node.next);
            t.next = node;
            node.next = null;
        }
        return node;
    }

    //推荐这种
    public ListNode reverseList3(ListNode head){
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

}
