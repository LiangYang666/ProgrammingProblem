package com.liang.剑指OfferII.链表;

import com.liang.utils.ListNode;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.剑指OfferII.链表
 * @ClassName: M023两个链表的第一个重合节点
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2021/12/23 9:34
 * @Version: 1.0
 */
public class S023两个链表的第一个重合节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {   //冗长
        int i=0;
        int j=0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA!=null || nodeB!=null){
            if (nodeA!=null){
                i++;
                nodeA=nodeA.next;
            }
            if (nodeB!=null){
                j++;
                nodeB=nodeB.next;

            }
        }
        nodeA=headA;
        nodeB=headB;
        if (i<j){
            nodeA = headB;
            nodeB = headA;
            int t = j;
            j = i;
            i = t;
        }
        int t = i-j;
        for (int k = 0; k < t; k++) {
            nodeA = nodeA.next;
        }
        while (nodeA!=null){
            if (nodeA==nodeB)   return nodeA;
            nodeA=nodeA.next;
            nodeB=nodeB.next;
        }
        return null;
    }
    //应该使用这种方式
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA!=nodeB){
            nodeA = nodeA==null?headB:nodeA.next;
            nodeB = nodeB==null?headA:nodeB.next;
        }
        return nodeA;
    }
}
