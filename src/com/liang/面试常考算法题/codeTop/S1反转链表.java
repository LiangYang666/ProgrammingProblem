package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.常考算法题.codeTop
 * @ClassName: T1反转链表
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/22 8:45
 * @Version: 1.0
 */
public class S1反转链表 {
    public ListNode reverseList0(ListNode head) {    //迭代方法
        if (head==null) return null;
        ListNode next;
        ListNode last=null;
        while (head.next!=null){
            next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
        head.next = last;
        return head;
    }
    public ListNode reverseList(ListNode head){ //递归
        return reverseNodes(head, null);
    }
    public ListNode reverseNodes(ListNode node, ListNode last) {
        if (node==null) return node;
        ListNode next = node.next;
        node.next = last;
        return reverseNodes(next, node);
    }

}
