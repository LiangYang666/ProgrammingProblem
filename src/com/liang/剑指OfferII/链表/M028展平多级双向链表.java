package com.liang.剑指OfferII.链表;

import java.util.LinkedList;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.剑指OfferII.链表
 * @ClassName: M028展平多级双向链表
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2021/12/24 11:15
 * @Version: 1.0
 */
public class M028展平多级双向链表 {
    public Node flatten(Node head) {        // 我认为可行 但连接方式不同 造成不可行
        LinkedList<Node> heads = new LinkedList<>();
        Node cur = head;
        while (cur!=null && (cur.next!=null || !heads.isEmpty())){
            if (cur.next!=null){
                System.out.println(cur.val);
                if (cur.child!=null){
                    heads.addLast(cur.child);
                    cur.child = null;
                }
            } else {
                Node temp = heads.removeFirst();
                cur.next = temp;
                temp.prev = cur;
            }
            cur=cur.next;
        }
        return head;
    }
    public Node flatten1(Node head){
        LinkedList<Node> heads = new LinkedList<>();
        Node cur = head;
        while (true) {
            if (cur==null)  break;
            if (cur.child!=null){
                if (cur.next!=null) heads.addLast(cur.next);
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            } else if(cur.next!=null){

            } else if(!heads.isEmpty()){
                Node temp = heads.removeLast();
                cur.next = temp;
                temp.prev = cur;
            } else {
                break;
            }
            cur=cur.next;
        }
        return head;
    }
}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

